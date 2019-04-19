package com.initcat.frontend.service.impl.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.initcat.frontend.model.request.user.RegisterRequest;
import com.initcat.frontend.model.response.user.RegisterResponse;
import com.initcat.frontend.service.user.FrontUserRegisterService;
import com.initcat.user_common.model.req.RegisterReq;
import com.initcat.user_common.model.resp.RegisterResp;
import com.initcat.user_common.service.user.UserRegisterService;
import org.springframework.stereotype.Service;

/**
 * 注册service
 *
 * @author libo
 * @package com.initcat.user_service.service.impl.user
 * @company xmiles
 * @date 2019/4/19
 */
@Service
public class FrontUserRegisterServiceImpl implements FrontUserRegisterService {

    @Reference
    private UserRegisterService userRegisterService;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterReq registerReq = RegisterReq.builder().build();
        RegisterResp registerResp = userRegisterService.register(registerReq);
        return RegisterResponse.builder().registerStatus(registerResp.isRegisterStatus())
                .msg(registerResp.getRegisterStatusEnum().getMsg()).build();
    }

}
