package com.initcat.user_service.service;

import com.initcat.user_service.model.db.CoinAccountInfo;


public interface CoinService {
    CoinAccountInfo openAccount();

    void recharge();

    void consume();
}
