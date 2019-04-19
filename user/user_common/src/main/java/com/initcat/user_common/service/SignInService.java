package com.initcat.user_common.service;


import com.initcat.user_common.dto.SignInResultDTO;

public interface SignInService {
    /**
     * 签到
     *
     * @param userId 用户ID
     * @return
     */
    SignInResultDTO signIn(Long userId);
}
