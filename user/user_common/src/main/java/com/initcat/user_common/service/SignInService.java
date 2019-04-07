package com.initcat.user_common.service;


import com.initcat.user_common.model.dto.SignInResultDTO;
import com.initcat.user_common.model.req.SignInReq;

public interface SignInService {
    /**
     * 签到
     *
     * @param userId
     * @return
     */
    SignInResultDTO signIn(SignInReq signInReq);
}
