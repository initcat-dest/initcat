package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.SignInDao;
import com.initcat.user_service.model.db.SignInInfo;
import com.initcat.user_service.repository.SignInInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignInDaoImpl implements SignInDao {
    // TODO song 这里要空一行在开始写代码
    @Autowired
    private SignInInfoRepository signInInfoRepository;


    @Override
    public SignInInfo findUser(Long userId) {
        // TODO song 这里可以直接return 不需要写等于号前面的代码
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
