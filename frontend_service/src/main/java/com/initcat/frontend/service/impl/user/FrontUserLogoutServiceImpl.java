package com.initcat.frontend.service.impl.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.initcat.frontend.model.request.user.LogoutRequest;
import com.initcat.frontend.service.user.FrontUserLogoutService;
import com.initcat.user_common.service.user.UserLogoutService;
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
public class FrontUserLogoutServiceImpl implements FrontUserLogoutService {

	@Reference
	private	UserLogoutService userLogoutService;

	@Override
	public void logout(LogoutRequest logoutRequest) {
		userLogoutService.logOut("test");
	}
}
