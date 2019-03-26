package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.WalletAccountInfoDTO;
import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_service.dao.WalletDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.model.db.WalletAccountInfo;
import com.initcat.user_service.repository.CoinRepository;
import com.initcat.user_service.service.CoinService;
import com.initcat.user_service.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.initcat.user_common.model.enums.WalletTransResultEnum.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class CoinServiceImpl implements CoinService {
    private static Logger logger = LoggerFactory.getLogger(CoinServiceImpl.class);

    @Autowired
    CoinRepository coinRepository;
    @Autowired
    WalletDao walletDao;
    //CoinDao coinDao;

    /**
     * 开户
     */
    @Override
    public CoinAccountInfo openAccount(Long userId) {
        if (userId==null) {
            return null;
        }
        CoinAccountInfo accountInfo = new CoinAccountInfo();
        accountInfo.setUserId(userId);
        accountInfo.setAccountStatus(1);
        accountInfo.setCoinBalance(0);
        accountInfo.setCreateTime(new Date());
        return coinRepository.save(accountInfo);
    }

    /**
     * 充值
     * @param coinBalance
     * @param accountStatus
     * @param operateCoin
     * @return
     */
    @Override
    public WalletTransResultDTO recharge(Long userId, int coinBalance, int accountStatus, int operateCoin,
                                         int tradeCode, String transMsg, Long businessId) {
        try {
            //校验参数
            if (userId==null|| operateCoin<=0||tradeCode<=0){
                return WalletTransResultDTO.builder().transResult(PARAMETER_ILLEGAL).build();
            }
            //根据消费类型和业务ID进行缓存锁
            String redisLockKey="waller:recharge:"+userId+":"+tradeCode+":"+businessId;
            if (!RedisUtils.setnxex(redisLockKey,"1",5)) {
                return  WalletTransResultDTO.builder().transResult(REPEAT_REQUEST).build();
            }
            // 通过锁的方式获取账户信息，并校验账户是否存在 和 检验账户状态
            WalletAccountInfo accountInfo=walletDao.findByUserIdForUpdate(userId);
            if (accountInfo == null) {
                // 如果用户不存在，账户开户，开完户再进行for update锁
                openAccount(userId);
                accountInfo=walletDao.findByUserIdForUpdate(userId);
            }
            //校验账户状态
            if (accountInfo==null||accountInfo.getAccountStatus()!=1) {
                return WalletTransResultDTO.builder().transResult(ACCOUNT_ILLEGAL).build();
            }
            // 交易完成后余额
           Integer  tradeCoin=accountInfo.getWalletBalance()+operateCoin;

            // 添加金币充值记录
            boolean saveStatus=walletDao.saveTransRecord(userId, operateCoin, tradeCode, 1, transMsg, businessId, tradeCoin);
            if (!saveStatus) {
                //保存交易记录失败，直接返回
                return WalletTransResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
            }
            //添加金币消费记录成功，更新账户金币金额
            accountInfo.setWalletBalance(tradeCoin);
            walletDao.updateAccountInfo(accountInfo);
            WalletAccountInfoDTO accountInfoDTO= WalletAccountInfoDTO.builder().userId(userId).walletBalance(tradeCoin).build();
            return WalletTransResultDTO.builder().transResult(SUCCESS).walletAccountInfo(accountInfoDTO).build();
        } catch (Exception e) {
            //手动回滚事物
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("walletRechange error userid:"+userId+",transCode:"+tradeCode+
                   ",operateCoin:"+operateCoin,e);
         return WalletTransResultDTO.builder().transResult(SERVICE_ERROR).build();
        }
    }

    /**
     * 消费
     * @param coinBalance
     * @param accountStatus
     * @param operateCoin
     * @param transCode
     * @param transMsg
     * @param tradeCoin
     * @return
     */
    @Override
    public Map<Object, Object> consume(Integer coinBalance, Integer accountStatus, Integer operateCoin,
                                       Integer transCode, String transMsg, Integer tradeCoin) {
        if (operateCoin > coinBalance) {
            throw new IllegalArgumentException("金币不足，请充值");
        }
        tradeCoin=coinBalance-operateCoin;
        Map<Object,Object> map=new HashMap<>();
        map.put("tradeCoin", tradeCoin);
        return map;
    }

}
