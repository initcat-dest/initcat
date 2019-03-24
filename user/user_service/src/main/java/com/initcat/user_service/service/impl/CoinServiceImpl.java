package com.initcat.user_service.service.impl;

import com.initcat.user_service.repository.CoinRepository;
import com.initcat.user_service.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class CoinServiceImpl implements CoinService {
    @Autowired
    CoinRepository coinRepository;

    /**
     * 开户
     * @param coinBalance
     * @param accountStatus
     * @return
     */
    @Override
    public Map<Object, Object> openAccount(Long coinBalance, Integer accountStatus) {
        if (accountStatus!=1){
            throw new IllegalArgumentException("您已开启金币模式");
        }
        Map<Object,Object> map=new HashMap<>();
        map.put("coinBalance",0);
        map.put("accountStatus",1);
        //Object o= coinRepository.updateAccount(map);
        return map;
    }

    /**
     * 充值
     * @param coinBalance
     * @param accountStatus
     * @param operateCoin
     * @param tradeCoin
     * @return
     */
    @Override
    public Map<Object,Object> recharge(Integer coinBalance, Integer accountStatus, Integer operateCoin, Integer tradeCoin) {
        if (accountStatus!=1){
            throw new IllegalArgumentException("请您先你开启金币模式");
        }
        tradeCoin=operateCoin+coinBalance;
        Map<Object,Object> map=new HashMap<>();
        map.put("tradeCoin", tradeCoin);
        return map;
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
