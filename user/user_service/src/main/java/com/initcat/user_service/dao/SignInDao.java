package com.initcat.user_service.dao;


import com.initcat.user_service.model.db.SignInInfo;

public interface SignInDao {

    /**
     * 查询签到信息
     */
    SignInInfo findSignInInfo(Long userId);

    /**
     * 更新签到信息
     */
    void updateSignInInfo(SignInInfo signInInfo);

    /**
     * 向签到表内插入用户数据
     */
    void insertInfo(SignInInfo signInInfo);
}
