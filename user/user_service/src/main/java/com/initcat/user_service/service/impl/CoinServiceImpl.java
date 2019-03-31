package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.CoinAccountInfoDTO;
import com.initcat.user_common.model.dto.CoinTransRecordDTO;
import com.initcat.user_service.dao.CoinDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.service.CoinService;
import com.initcat.user_service.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

import static com.initcat.user_common.model.enums.CointransRecordEnum.*;

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
    public CoinTransRecordDTO openAccount(Long userId) {
        if (userId == null) {
            return null;
        }
        CoinAccountInfo accountInfo = new CoinAccountInfo();
        accountInfo.setUserId(userId);
        accountInfo.setAccountStatus(1);
        accountInfo.setCoinBalance(0);
        if (accountInfo.getUserId() == null || accountInfo.getAccountStatus() != 1) {
            return CoinTransRecordDTO.builder().transResult(PARAMETER_ILLEGAL).build();
        }
        accountInfo.setCreateTime(new Date());
        coinDao.saveAccountInfo(accountInfo);
        return CoinTransRecordDTO.builder().transResult(SUCCESS).build();
    }

    /**
     * 充值
     *
     * @param accountStatus
     * @param operateCoin
     * @return
     */
    @Override
    @Transactional
    public CoinTransRecordDTO recharge(Long userId, int accountStatus, int operateCoin,
                                       int transCode, String transMsg, Long businessId) {
        try {
            //校验参数
            if (userId == null || operateCoin <= 0 || transCode <= 0) {
                return CoinTransRecordDTO.builder().transResult(PARAMETER_ILLEGAL).build();
            }
            //根据消费类型和业务ID进行缓存锁
            String redisLockKey = "coin:recharge:" + userId + ":" + transCode + ":" + businessId;
            if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
                return CoinTransRecordDTO.builder().transResult(REPEAT_REQUEST).build();
            }
            // 通过锁的方式获取账户信息，并校验账户是否存在 和 检验账户状态
            CoinAccountInfo accountInfo = coinDao.findByUserIdForUpdate(userId);
            if (accountInfo == null) {
                // 如果用户不存在，账户开户，开完户再进行for update锁
                openAccount(userId);
                accountInfo = coinDao.findByUserIdForUpdate(userId);
            }
            //校验账户状态
            if (accountInfo == null || accountInfo.getAccountStatus() != 1) {
                return CoinTransRecordDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
            }
            // 交易完成后余额
            Integer tradeCoin = accountInfo.getCoinBalance() + operateCoin;

            // 添加金币充值记录
            boolean saveStatus = coinDao.saveTransRecord(userId, operateCoin, transCode, 1, transMsg, businessId, tradeCoin);
            if (!saveStatus) {
                //保存交易记录失败，直接返回
                return CoinTransRecordDTO.builder().transResult(SAVE_RECORD_ERROR).build();
            }
            //添加金币消费记录成功，更新账户金币金额
            accountInfo.setCoinBalance(tradeCoin);
            coinDao.updateAccountInfo(accountInfo);
            CoinAccountInfoDTO accountInfoDTO = CoinAccountInfoDTO.builder().userId(userId).coinBalance(tradeCoin).build();
            return CoinTransRecordDTO.builder().transResult(SUCCESS).coinAccountInfo(accountInfoDTO).build();
        } catch (Exception e) {
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("coinRechange error userid:" + userId + ",transCode:" + transCode +
                    ",operateCoin:" + operateCoin, e);
            return CoinTransRecordDTO.builder().transResult(SERVICE_ERROR).build();
        }
    }

    /**
     * 消费
     *
     * @param accountStatus
     * @param operateCoin
     * @param transCode
     * @param transMsg
     * @return
     */
    @Override
    @Transactional
    public CoinTransRecordDTO consume(Long userId, int accountStatus, int operateCoin,
                                      int transCode, String transMsg, Long businessId) {

        try {
            // 校验参数是否合法
            if (userId == null || operateCoin <= 0 || transCode <= 0) {
                return CoinTransRecordDTO.builder().transResult(PARAMETER_ILLEGAL).build();
            }
            // 根据业务id和消费类型加缓存锁
            String redisLockKey = "coin:consume:" + userId + ":" + transCode + ":" + businessId;
            if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
                return CoinTransRecordDTO.builder().transResult(REPEAT_REQUEST).build();
            }

            // 检查用户状态与用户余额，并校验用户状态
            CoinAccountInfo coinAccountInfo = coinDao.findByUserIdForUpdate(userId);
            // 消费的业务不需要实现开户，就像银行取钱，没有卡的情况下怎么给你取，即使给你开户了，里面照样没有钱
            // 校验用户状态
            if (coinAccountInfo == null || coinAccountInfo.getAccountStatus() != 1) {
                return CoinTransRecordDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
            }
            // 校验消费金额是否大于等于余额
            if (operateCoin >= coinAccountInfo.getCoinBalance()) {
                return CoinTransRecordDTO.builder().transResult(LACK_BALANCE).build();
            }
            // 交易后余额
            Integer tradeCoin = coinAccountInfo.getCoinBalance() - operateCoin;
            // 添加金币消费记录
            Boolean saveStatus = coinDao.saveTransRecord(userId, operateCoin, transCode, 2, transMsg, businessId, tradeCoin);
            if (!saveStatus) {
                // 如果添加金币消费记录失败，直接返回
                return CoinTransRecordDTO.builder().transResult(SAVE_RECORD_ERROR).build();
            }
            // 更新金币消费金额
            coinAccountInfo.setCoinBalance(tradeCoin);
            coinDao.updateAccountInfo(coinAccountInfo);
            CoinAccountInfoDTO accountInfoDTO = CoinAccountInfoDTO.builder().userId(userId).coinBalance(tradeCoin).build();
            return CoinTransRecordDTO.builder().transResult(SUCCESS).coinAccountInfo(accountInfoDTO).build();
        } catch (Exception e) {
            // 手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("coinConsume error userid:" + userId + ",transCode:" + transCode +
                    ",operateCoin:" + operateCoin, e);
            return CoinTransRecordDTO.builder().transResult(SERVICE_ERROR).build();
        }
    }

}
