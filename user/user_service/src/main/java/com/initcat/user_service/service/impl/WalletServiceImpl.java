package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.WalletAccountInfoDTO;
import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_service.dao.WalletDao;
import com.initcat.user_service.model.db.WalletAccountInfo;
import com.initcat.user_service.service.WalletService;
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
	public WalletAccountInfo openAccount(Long userId) {
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
	@Transactional
	public WalletTransResultDTO recharge(Long userId, int transCode, String transMsg, int rechargeMoney, Long businessId) {

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
	public WalletTransResultDTO consume(Long userId, int transCode, String transMsg, int consumeMoney, Long businessId) {
		return null;
	}
}
