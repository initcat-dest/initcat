package com.initcat.user_common.service;


import com.initcat.user_common.model.dto.SignInResultDTO;

public interface SignInService {
    /**
     * 签到
     *
     * @param userId
     * @return
     */
    SignInResultDTO signIn(Long userId);
}
