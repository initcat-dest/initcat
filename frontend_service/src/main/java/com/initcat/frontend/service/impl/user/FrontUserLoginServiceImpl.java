package com.initcat.frontend.service.impl.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.initcat.common.model.BaseResult;
import com.initcat.frontend.model.request.user.LoginRequest;
import com.initcat.frontend.model.response.user.LoginResponse;
import com.initcat.frontend.service.user.FrontUserLoginService;
import com.initcat.user_common.dto.CommUserDTO;
import com.initcat.user_common.enums.LoginStatusEnum;
import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.model.resp.LoginResp;
import com.initcat.user_common.service.user.UserLoginService;
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
public class FrontUserLoginServiceImpl implements FrontUserLoginService {

	@Reference
	private	UserLoginService userLoginService;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		LoginReq loginReq = LoginReq.builder().phone(loginRequest.getPhone()).passward(loginRequest.getPassward()).build();
		LoginResp loginResp = userLoginService.login(loginReq);

		LoginStatusEnum loginStatusEnum = loginResp.getLoginStatusEnum();
		boolean isSuccess = BaseResult.SUCCESS.getCode() == loginStatusEnum.getCode();
		CommUserDTO commUserInfo = loginResp.getCommUser();
		return LoginResponse.builder().loginStatus(isSuccess).msg(loginStatusEnum.getMsg()).commUserInfo(commUserInfo).build();
	}
}
