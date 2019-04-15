package com.initcat.user_service.dao;


import com.initcat.user_service.model.db.SignInInfo;

public interface SignInDao {

    /**
     * 查询用户信息
     */
    SignInInfo findSignInInfo(Long userId);

    /**
     * 更新账户
     */
    void updateSignInInfo(SignInInfo signInInfo);

    /**
     * 向签到表内插入用户数据
     */
    void insertInfo(SignInInfo signInInfo);
}
