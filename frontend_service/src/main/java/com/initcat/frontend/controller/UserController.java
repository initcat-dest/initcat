package com.initcat.frontend.controller;

import com.initcat.frontend.model.request.user.LoginRequest;
import com.initcat.frontend.model.request.user.LogoutRequest;
import com.initcat.frontend.model.response.user.LoginResponse;
import com.initcat.frontend.service.user.FrontUserLoginService;
import com.initcat.frontend.service.user.FrontUserLogoutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * class description
 *
 * @author libo
 * @package com.frontend.controller
 * @company xmiles
 * @date 2019/3/9
 */
@Controller
@RequestMapping(path = "/user")
@Api(value = "用户controller", tags = "用户controller")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	FrontUserLoginService userLoginService;
	@Autowired
	FrontUserLogoutService userLogoutService;


	@GetMapping(value = "login-view")
	@ApiOperation(value = "用户登录页")
	public String loginView() {
		logger.info(" access loginView");
		return "fore_jsp/UserLogin";
	}

	@ResponseBody
	@PostMapping(value = "login", consumes = "application/json")
	@ApiOperation(value = "用户登录")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		logger.info(" access login");
		return userLoginService.login(loginRequest);
	}

	@PostMapping(value = "logout", consumes = "application/json")
	@ApiOperation(value = "用户登出")
	public void logout(@RequestBody LogoutRequest logoutRequest) {
		logger.info(" access logout");
		userLogoutService.logout(logoutRequest);
	}

}
