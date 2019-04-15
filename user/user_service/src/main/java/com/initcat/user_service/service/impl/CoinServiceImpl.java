package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.CoinAccountInfoDTO;
import com.initcat.user_common.model.dto.CoinTransRecordDTO;
import com.initcat.user_common.model.dto.CoinTransResultDTO;
import com.initcat.user_common.model.req.CoinConsumeReq;
import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.service.CoinService;
import com.initcat.user_service.dao.CoinDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.model.db.CoinTransRecord;
import com.initcat.user_service.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.initcat.user_common.model.enums.CoinTransRecordEnum.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class CoinServiceImpl implements CoinService {

    private static Logger logger = LoggerFactory.getLogger(CoinServiceImpl.class);

    @Autowired
    CoinDao coinDao;

    /**
     * 开户
     */
    @Override
    public CoinTransResultDTO openAccount(Long userId) {
        if (userId == null) {
            return null;
        }
        CoinAccountInfo accountInfo = new CoinAccountInfo();
        accountInfo.setUserId(userId);
        accountInfo.setAccountStatus(1);
        accountInfo.setCoinBalance(0);
        if (accountInfo.getUserId() == null || accountInfo.getAccountStatus() != 1) {
            return CoinTransResultDTO.builder().transResult(PARAMETER_ILLEGAL).build();
        }
        accountInfo.setCreateTime(new Date());
        coinDao.saveAccountInfo(accountInfo);
        return CoinTransResultDTO.builder().transResult(SUCCESS).build();
    }

    /**
     * 充值
     * <p>
     * =
     *
     * @return
     */
    @Override
    @Transactional
    public CoinTransResultDTO recharge(CoinRechargeReq coinRechargeReq) {
        logger.info("recharge: start userId: "+ coinRechargeReq.getUserId() + ", rechargeCoin:" + coinRechargeReq.getRechargeCoin());
        try {
            // 校验参数
            if (coinRechargeReq.getUserId() == null || coinRechargeReq.getRechargeCoin() <= 0 || coinRechargeReq.getTransCode() <= 0) {
                logger.info("recharge: 参数错误 userId: "+ coinRechargeReq.getUserId());
                return CoinTransResultDTO.builder().transResult(PARAMETER_ILLEGAL).build();
            }
            // 根据消费类型和业务ID进行缓存锁
            String redisLockKey = "coin:recharge:" + coinRechargeReq.getUserId() + ":" + coinRechargeReq.getTransCode() + ":" + coinRechargeReq.getBusinessId();
            if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
                logger.info("recharge: 未拿到缓存锁 userId: "+ coinRechargeReq.getUserId() + ",transCode:" + coinRechargeReq.getTransCode() +
                        ",operateCoin:" + coinRechargeReq.getRechargeCoin());
                return CoinTransResultDTO.builder().transResult(REPEAT_REQUEST).build();
            }
            // 通过锁的方式获取账户信息，并校验账户是否存在 和 检验账户状态
            CoinAccountInfo accountInfo = coinDao.findByUserIdForUpdate(coinRechargeReq.getUserId());
            if (accountInfo == null) {
                // 如果用户不存在，账户开户，开完户再进行for update锁
                openAccount(coinRechargeReq.getUserId());
                accountInfo = coinDao.findByUserIdForUpdate(coinRechargeReq.getUserId());
            }
            // 校验账户状态
            if (accountInfo == null || accountInfo.getAccountStatus() != 1) {
                logger.info("recharge: 账户异常 userId: "+ coinRechargeReq.getUserId() + ",transCode:" + coinRechargeReq.getTransCode() +
                        ",operateCoin:" + coinRechargeReq.getRechargeCoin());
                return CoinTransResultDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
            }
            // 交易完成后余额
            Integer tradeCoin = accountInfo.getCoinBalance() + coinRechargeReq.getRechargeCoin();

            // 添加金币充值记录
            boolean saveStatus = coinDao.saveTransRecord(coinRechargeReq.getUserId(), coinRechargeReq.getRechargeCoin(), coinRechargeReq.getTransCode(), 1, coinRechargeReq.getTransMsg(), coinRechargeReq.getBusinessId(), tradeCoin);
            if (!saveStatus) {
                // 保存交易记录失败，直接返回
                logger.info("recharge: 保存交易记录失败 userid: "+ coinRechargeReq.getUserId());
                return CoinTransResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
            }
            //添加金币消费记录成功，更新账户金币金额
            accountInfo.setCoinBalance(tradeCoin);
            coinDao.updateAccountInfo(accountInfo);
            CoinAccountInfoDTO accountInfoDTO = CoinAccountInfoDTO.builder().userId(coinRechargeReq.getUserId()).coinBalance(tradeCoin).build();
            return CoinTransResultDTO.builder().transResult(SUCCESS).coinAccountInfo(accountInfoDTO).build();
        } catch (Exception e) {
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("coinRecharge error userId:" + coinRechargeReq.getUserId() + ",transCode:" + coinRechargeReq.getTransCode() +
                    ",operateCoin:" + coinRechargeReq.getRechargeCoin(), e);
            return CoinTransResultDTO.builder().transResult(SERVICE_ERROR).build();
        }
    }

    /**
     * 消费
     *
     * @return
     */
    @Override
    @Transactional
    public CoinTransResultDTO consume(CoinConsumeReq coinConsumeReq) {

        try {
            // 校验参数是否合法
            if (coinConsumeReq.getUserId() == null || coinConsumeReq.getOperateCoin() <= 0 || coinConsumeReq.getTransCode() <= 0) {
                return CoinTransResultDTO.builder().transResult(PARAMETER_ILLEGAL).build();
            }
            // 根据业务id和消费类型加缓存锁
            String redisLockKey = "coin:consume:" + coinConsumeReq.getUserId() + ":" + coinConsumeReq.getTransCode() + ":" + coinConsumeReq.getBusinessId();
            if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
                return CoinTransResultDTO.builder().transResult(REPEAT_REQUEST).build();
            }

            // 检查用户状态与用户余额，并校验用户状态
            CoinAccountInfo coinAccountInfo = coinDao.findByUserIdForUpdate(coinConsumeReq.getUserId());
            // 消费的业务不需要实现开户，就像银行取钱，没有卡的情况下怎么给你取，即使给你开户了，里面照样没有钱
            // 校验用户状态
            if (coinAccountInfo == null || coinAccountInfo.getAccountStatus() != 1) {
                return CoinTransResultDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
            }
            // 校验消费金额是否大于等于余额
            if (coinConsumeReq.getOperateCoin() >= coinAccountInfo.getCoinBalance()) {
                return CoinTransResultDTO.builder().transResult(LACK_BALANCE).build();
            }
            // 交易后余额
            Integer tradeCoin = coinAccountInfo.getCoinBalance() - coinConsumeReq.getOperateCoin();
            // 添加金币消费记录
            Boolean saveStatus = coinDao.saveTransRecord(coinConsumeReq.getUserId(), coinConsumeReq.getOperateCoin(), coinConsumeReq.getTransCode(), 2, coinConsumeReq.getTransMsg(), coinConsumeReq.getBusinessId(), tradeCoin);
            if (!saveStatus) {
                // 如果添加金币消费记录失败，直接返回
                return CoinTransResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
            }
            // 更新金币消费金额
            coinAccountInfo.setCoinBalance(tradeCoin);
            coinDao.updateAccountInfo(coinAccountInfo);
            CoinAccountInfoDTO accountInfoDTO = CoinAccountInfoDTO.builder().userId(coinConsumeReq.getUserId()).coinBalance(tradeCoin).build();
            return CoinTransResultDTO.builder().transResult(SUCCESS).coinAccountInfo(accountInfoDTO).build();
        } catch (Exception e) {
            // 手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("coinConsume error userid:" + coinConsumeReq.getUserId() + ",transCode:" + coinConsumeReq.getTransCode() +
                    ",operateCoin:" + coinConsumeReq.getOperateCoin(), e);
            return CoinTransResultDTO.builder().transResult(SERVICE_ERROR).build();
        }
    }

    @Override
    public List<CoinTransRecordDTO> listTransRecord(Long userId, int pageNum, int pageSize) {
        Page<CoinTransRecord> coinTransRecords = coinDao.listTransRecord(userId, pageNum, pageSize);
        List<CoinTransRecord> content = coinTransRecords.getContent();
        List<CoinTransRecordDTO> CoinTransRecordDTOs = new ArrayList<>();
        CoinTransRecordDTO coinTransRecordDTO;
        for (CoinTransRecord record : content) {
            coinTransRecordDTO = new CoinTransRecordDTO();
            BeanUtils.copyProperties(record, coinTransRecordDTO);
            CoinTransRecordDTOs.add(coinTransRecordDTO);
        }
        return CoinTransRecordDTOs;
    }

}
