package com.initcat.frontend.service.user;

import com.initcat.frontend.model.request.user.LoginRequest;
import com.initcat.frontend.model.response.user.LoginResponse;

/**
 * 用户登录service
 */
public interface FrontUserLoginService {
	LoginResponse login(LoginRequest loginRequest);
}
