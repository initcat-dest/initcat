package com.initcat.user_service.service;

import java.util.Map;


public interface CoinService {
    /**
     * 开户
     * @return
     */
    Map<Object, Object> openAccount(Long coinBalance, Integer accountStatus);

    /**
     * 充值
     */
    Map<Object, Object> recharge(Integer coinBalance,Integer accountStatus,Integer operateCoin,
                                 Integer tradeCoin);

    /**
     * 消费
     */
    Map<Object, Object> consume(Integer coinBalance,Integer accountStatus,Integer operateCoin,
                                Integer transCode,String transMsg, Integer tradeCoin);
}
