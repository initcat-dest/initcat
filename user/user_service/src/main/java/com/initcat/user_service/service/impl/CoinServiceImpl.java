package com.initcat.user_service.service.impl;

import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.service.CoinService;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class CoinServiceImpl implements CoinService {
    @Override
    public CoinAccountInfo openAccount() {
        return null;
    }

    @Override
    public void recharge() {

    }

    @Override
    public void consume() {

    }
}
