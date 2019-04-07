package com.initcat.user_service.dao.impl;

import com.initcat.user_common.model.req.SignInReq;
import com.initcat.user_service.dao.SignInDao;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.model.db.SignInInfo;
import com.initcat.user_service.repository.SignInInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SignInDaoImpl implements SignInDao {
    @Autowired
    private SignInInfoRepository signInInfoRepository;

    @Override
    public SignInInfo findByUserIdForUpdate(Long userId) {
        return signInInfoRepository.findById(userId);
    }

    @Override
    public void updateAccountInfo(SignInInfo signInInfo) {
        signInInfoRepository.saveAndFlush(signInInfo);
    }
}
