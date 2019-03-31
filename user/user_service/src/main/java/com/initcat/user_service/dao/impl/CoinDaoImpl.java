package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.CoinDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.model.db.CoinTransRecord;
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
        coinAccountInfoRepository.save(accountInfo);
    }

    @Override
    public void updateAccountInfo(CoinAccountInfo coinAccountInfo) {
        coinAccountInfoRepository.updateByUserId(coinAccountInfo);
    }

    @Override
    public CoinAccountInfo findByUserId(Long userId) {
        return coinAccountInfoRepository.findByUserId(userId);
    }

    @Override
    public CoinAccountInfo findByUserIdForUpdate(Long userId) {
        return coinAccountInfoRepository.queryByUserId(userId);
    }

    @Override
    public boolean saveTransRecord(Long userId, int operateCoin, int transCode, int operateType, String transMsg, Long businessId, int tradeCoin) {
        CoinTransRecord coinTransRecord= new CoinTransRecord();
        coinTransRecord.setUserId(userId);
        coinTransRecord.setOperateCoin(operateCoin);
        coinTransRecord.setTransCode(transCode);
        coinTransRecord.setOperateType(operateType);
        coinTransRecord.setTransMsg(transMsg);
        coinTransRecord.setBusinessId(businessId);
        coinTransRecord.setTradeCoin(tradeCoin);
        coinTransRecordRepository.save(coinTransRecord);
        return false;
    }
}
