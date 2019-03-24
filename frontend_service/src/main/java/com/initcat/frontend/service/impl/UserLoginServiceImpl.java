package com.initcat.frontend.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.initcat.frontend.model.LoginRequest;
import com.initcat.frontend.model.LoginResponse;
import com.initcat.frontend.service.UserLoginService;
import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.service.UserService;
import org.springframework.stereotype.Service;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.frontend.service.impl
 * @company xmiles
 * @date 2019/3/24
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Reference
	UserService userService;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		LoginReq req = new LoginReq();
		userService.login(req)
		return null;
	}
}
