package com.initcat.user_service.controller;

import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.model.req.LogoutReq;
import com.initcat.user_common.model.resp.LoginResp;
import com.initcat.user_common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录
 *
 * @author libo
 * @package com.initcat.controller
 * @company initcat
 * @date 2018/11/26
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login", consumes = "application/json")
    public LoginResp login(@Valid @RequestBody LoginReq request) {
        LoginResp login = userService.login(request);
        return login;
    }

    @PostMapping(value = "/logout", consumes = "application/json")
    public String login(@Valid @RequestBody LogoutReq request) {
        return "退出成功";
    }


}

