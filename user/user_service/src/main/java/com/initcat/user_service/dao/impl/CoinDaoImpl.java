package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.CoinDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.repository.CoinAccountInfoRepository;
import com.initcat.user_service.repository.CoinTransRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoinDaoImpl implements CoinDao {
    @Autowired
    CoinAccountInfoRepository coinAccountInfoRepository;

    @Autowired
    CoinTransRecordRepository coinTransRecordRepository;
    @Override
    public void saveAccountInfo(CoinAccountInfo accountInfo) {

    }

    @Override
    public void updateAccountInfo(CoinAccountInfo accountInfo) {

    }

    @Override
    public CoinAccountInfo findByUserId(Long userId) {
        return null;
    }

    @Override
    public CoinAccountInfo findByUserIdForUpdate(Long userId) {
        return null;
    }

    @Override
    public boolean saveTransRecord(Long userId, int operateCoin, int transCode, int operateType, String transMsg, Long businessId, int tradeCoin) {
        return false;
    }
}
