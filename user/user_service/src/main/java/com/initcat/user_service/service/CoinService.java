package com.initcat.user_service.service;

import com.initcat.user_common.model.dto.CoinTransRecordDTO;


public interface CoinService {
    /**
     * 开户
     * @return
     */
    CoinTransRecordDTO openAccount(Long userId);

    /**
     * 充值
     */
    CoinTransRecordDTO recharge(Long userId, int accountStatus, int operateCoin,
                                int transCode, String transMsg, Long businessId);

    /**
     * 消费
     */
    CoinTransRecordDTO consume(Long userId,int accountStatus,int operateCoin,
                                int transCode,String transMsg,Long businessId);
}
