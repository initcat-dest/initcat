package com.initcat.frontend.service;

import com.initcat.frontend.model.LoginRequest;
import com.initcat.frontend.model.LoginResponse;

/**
 * 用户登录service
 */
public interface UserLoginService {
	LoginResponse login(LoginRequest loginRequest);
}
