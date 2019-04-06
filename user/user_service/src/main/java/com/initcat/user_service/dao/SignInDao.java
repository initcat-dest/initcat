package com.initcat.user_service.dao;

import com.initcat.user_service.model.db.SignInInfo;

import java.util.Date;

public interface SignInDao {
    public SignInInfo saveSignInAccountInfo(Date lastSignTime, int countSignDay, int coinBalance);
}
