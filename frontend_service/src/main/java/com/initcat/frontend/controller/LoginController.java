package com.initcat.frontend.controller;

import com.initcat.frontend.model.LoginRequest;
import com.initcat.frontend.model.LoginResponse;
import com.initcat.frontend.service.UserLoginService;
import com.initcat.frontend.service.UserLogoutService;
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
@RequestMapping(path = "/login")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserLoginService userLoginService;
	@Autowired
	UserLogoutService userLogoutService;


	@GetMapping(value = "/loginView")
	public String loginView() {
		logger.info(" access loginView");
		return "fore_jsp/UserLogin";
	}

	@ResponseBody
	@PostMapping(value = "/doLogin", consumes = "application/json")
	public LoginResponse doLogin(@RequestBody LoginRequest loginRequest) {
		return userLoginService.login(loginRequest);
	}

	@GetMapping(value = "/doLogout")
	public void doLogout() {
		logger.info(" access doLogout");
		userLogoutService.logout();
	}

}
