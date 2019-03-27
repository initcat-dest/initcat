package com.initcat.user_service.service;

import com.initcat.user_common.model.dto.CoinTransRecordDTO;
import com.initcat.user_service.model.db.CoinAccountInfo;

import java.util.Map;


public interface CoinService {
    /**
     * 开户
     * @return
     */
    CoinAccountInfo openAccount(Long userId);

    /**
     * 充值
     */
    CoinTransRecordDTO recharge(Long userId, int coinBalance, int accountStatus, int operateCoin,
                                int tradeCode, String transMsg, Long businessId);

    /**
     * 消费
     */
    Map<Object, Object> consume(Integer coinBalance,Integer accountStatus,Integer operateCoin,
                                Integer transCode,String transMsg, Integer tradeCoin);
}
