package com.initcat.frontend.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.initcat.frontend.service.UserLogoutService;
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
public class UserLogoutServiceImpl implements UserLogoutService {

	@Reference
	UserService userService;

	@Override
	public void logout() {
		userService.logOut("test");
	}
}
