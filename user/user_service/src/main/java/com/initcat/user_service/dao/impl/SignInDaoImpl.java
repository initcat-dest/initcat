package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.SignInDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.model.db.SignInInfo;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SignInDaoImpl implements SignInDao {
    @Override
    public SignInInfo saveSignInAccountInfo(Date lastSignTime,int countSignDay, int coinBalance) {
        //TODO:返回值不正确
        CoinAccountInfo coinAccountInfo = new CoinAccountInfo();
        coinAccountInfo.setCoinBalance(coinBalance);
        SignInInfo signInInfo = new SignInInfo();
        signInInfo.setCountSignDay(countSignDay);
        signInInfo.setLastSignTime(lastSignTime);
        return signInInfo;
    }
}
