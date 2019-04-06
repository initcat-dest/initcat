package com.initcat.user_service.controller;

import com.initcat.user_common.model.dto.SignInResultDTO;
import com.initcat.user_common.model.resp.SignInResp;
import com.initcat.user_common.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin")
public class SignInController {
    @Autowired
    SignInService signInService;
    @PostMapping("/signIn")
    public SignInResp signIn(@RequestBody Long userId) {
        SignInResultDTO signInResultDTO = signInService.signIn(userId);
        SignInResp signInResp = new SignInResp();
        signInResp.setSignInResult(signInResultDTO);
        return  signInResp;
    }
}
