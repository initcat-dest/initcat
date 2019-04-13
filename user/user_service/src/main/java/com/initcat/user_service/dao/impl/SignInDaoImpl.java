package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.SignInDao;
import com.initcat.user_service.model.db.SignInInfo;
import com.initcat.user_service.repository.SignInInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignInDaoImpl implements SignInDao {
    @Autowired
    private SignInInfoRepository signInInfoRepository;


    @Override
    public SignInInfo findUser(Long userId) {
        SignInInfo signInInfo = signInInfoRepository.findById(userId);
        return signInInfo;
    }

    @Override
    public void updateAccountInfo(SignInInfo signInInfo) {
        signInInfoRepository.saveAndFlush(signInInfo);
    }

    @Override
    public void insertId(SignInInfo signInInfo) {
        signInInfoRepository.save(signInInfo);
    }
}
