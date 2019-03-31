package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.WalletAccountInfoDTO;
import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_common.model.req.WalletConsumeReq;
import com.initcat.user_common.model.req.WalletRechargeReq;
import com.initcat.user_common.service.WalletService;
import com.initcat.user_service.dao.WalletDao;
import com.initcat.user_service.model.db.WalletAccountInfo;
import com.initcat.user_service.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

import static com.initcat.user_common.model.enums.WalletTransResultEnum.*;

/**
 * 零钱service
 *
 * @author libo
 * @package com.initcat.user_service.service.impl
 * @company xmiles
 * @date 2019/3/24
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class WalletServiceImpl implements WalletService {

	private static Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

	@Autowired
	WalletDao walletDao;

	@Override
	public WalletAccountInfoDTO openAccountForView(Long userId) {
		WalletAccountInfo walletAccountInfo = openAccount(userId);
		int walletBalance = walletAccountInfo != null
				? walletAccountInfo.getWalletBalance()
				: 0;
		return WalletAccountInfoDTO.builder()
				.userId(userId).walletBalance(walletBalance).build();
	}

	private WalletAccountInfo openAccount(Long userId) {
		if (userId == null) {
			return null;
		}
		WalletAccountInfo accountInfo = new WalletAccountInfo();
		accountInfo.setUserId(userId);
		accountInfo.setAccountStatus(1);
		accountInfo.setWalletBalance(0);
		accountInfo.setCreateTime(new Date());
		if (RedisUtils.setnxex("wallet:openAccount:" + userId, "1", 3)) {
			walletDao.saveAccountInfo(accountInfo);
		}
		return accountInfo;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public WalletTransResultDTO recharge(WalletRechargeReq rechargeReq) {

		Long userId = rechargeReq.getUserId();
		int rechargeMoney = rechargeReq.getRechargeMoney();
		int transCode = rechargeReq.getTransCode();
		String transMsg = rechargeReq.getTransMsg();
		Long businessId = rechargeReq.getBusinessId();

		try {
			// 校验参数
			if (userId == null || rechargeMoney <= 0 || transCode <= 0) {
				return WalletTransResultDTO.builder().transResult(PARAMETER_ILLEGAL).build();
			}
			// 根据消费类型和业务ID进行缓存锁
			String redisLockKey = "wallet:recharge:" + userId + ":" + transCode + ":" + businessId;
			if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
				return WalletTransResultDTO.builder().transResult(REPEAT_REQUEST).build();
			}

			// 通过锁的方式获取账户信息，并校验账户是否存在 和 检验账户状态
			WalletAccountInfo accountInfo = walletDao.findByUserIdForUpdate(userId);
			if (accountInfo == null) {
				// 如果用户不存在，账户开户，开完户再进行for update锁
				openAccount(userId);
				accountInfo = walletDao.findByUserIdForUpdate(userId);
			}
			// 校验账户状态
			if (accountInfo == null || accountInfo.getAccountStatus() != 1) {
				return WalletTransResultDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
			}

			// 交易完成后余额
			Integer tradeMoney = accountInfo.getWalletBalance() + rechargeMoney;
			// 添加金币充值记录
			boolean saveStatus = walletDao.saveTransRecord(userId, rechargeMoney, transCode, 1,
					transMsg, businessId, tradeMoney);
			if (!saveStatus) {
				// 保存记录交易记录失败，直接返回
				return WalletTransResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
			}
			// 添加金币消费记录成功，更新账户金币余额
			accountInfo.setWalletBalance(tradeMoney);
			accountInfo.setUpdateTime(new Date());
			walletDao.updateAccountInfo(accountInfo);
			WalletAccountInfoDTO accountInfoDTO = WalletAccountInfoDTO.builder().userId(userId).walletBalance(tradeMoney).build();
			return WalletTransResultDTO.builder().transResult(SUCCESS).walletAccountInfo(accountInfoDTO).build();

		} catch (Exception e) {
			// 手动回滚事务
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("walletRechange error userid:" + userId + ", transCode:" + transCode
					+ ", rechargeMoney:" + rechargeMoney, e);
			return WalletTransResultDTO.builder().transResult(SERVICE_ERROR).build();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public WalletTransResultDTO consume(WalletConsumeReq consumeReq) {

		Long userId = consumeReq.getUserId();
		int consumeMoney = consumeReq.getConsumeMoney();
		int transCode = consumeReq.getTransCode();
		String transMsg = consumeReq.getTransMsg();
		Long businessId = consumeReq.getBusinessId();

		try {
			// 校验参数
			if (userId == null || consumeMoney <= 0 || transCode <= 0) {
				return WalletTransResultDTO.builder().transResult(PARAMETER_ILLEGAL).build();
			}
			// 加缓存锁
			String redisLockKey = "wallet:recharge" + userId + ":" + transCode + ":" + businessId;
			if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
				return WalletTransResultDTO.builder().transResult(REPEAT_REQUEST).build();
			}
			// 用锁的形势获取用户信息，并判断用户是否存在与校验用户状态
			WalletAccountInfo accountInfo = walletDao.findByUserIdForUpdate(userId);

			// 验证用户状态
			if (accountInfo == null || accountInfo.getAccountStatus() != 1) {
				return WalletTransResultDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
			}
			// 判断消费金额是否大于余额
			if (accountInfo.getWalletBalance() < consumeMoney) {
				return WalletTransResultDTO.builder().transResult(LACK_BALANCE).build();
			}
			Integer tradeMoney = accountInfo.getWalletBalance() - consumeMoney;
			// 添加金币消费记录
			Boolean saveStatus = walletDao.saveTransRecord(userId, consumeMoney, transCode, 2, transMsg, businessId, tradeMoney);
			if (!saveStatus) {
				// 保存失败，直接返回
				return WalletTransResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
			}
			// 添加消费记录，更新金币余额
			accountInfo.setWalletBalance(tradeMoney);
			accountInfo.setUpdateTime(new Date());
			walletDao.updateAccountInfo(accountInfo);
			WalletAccountInfoDTO walletAccountInfoDTO = WalletAccountInfoDTO.builder().userId(userId).walletBalance(tradeMoney).build();
			return WalletTransResultDTO.builder().transResult(SUCCESS).walletAccountInfo(walletAccountInfoDTO).build();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("walletConsume error userid:" + userId + ", transCode:" + transCode
					+ ", consumeMoney:" + consumeMoney, e);
			return WalletTransResultDTO.builder().transResult(SERVICE_ERROR).build();
		}

	}
}
