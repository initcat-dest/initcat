package com.initcat.user_service.dao;


import com.initcat.user_service.model.db.SignInInfo;

public interface SignInDao {
    //public SignInInfo saveSignInAccountInfo(Date lastSignTime, int countSignDay, int coinBalance);

    /**
     * 查询用户签到信息并进行加锁
     * @param userId
     * @return
     */
    SignInInfo findByUserIdForUpdate(Long userId);
    /**
     * 更新账户
     */
    void updateAccountInfo(SignInInfo signInInfo);
}
