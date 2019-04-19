package com.initcat.frontend.service.user;

import com.initcat.frontend.model.request.user.RegisterRequest;
import com.initcat.frontend.model.response.user.RegisterResponse;

/**
 * 注册service
 *
 * @author libo
 * @package com.initcat.frontend.service.user
 * @company xmiles
 * @date 2019/4/18
 */
public interface FrontUserRegisterService {

    RegisterResponse register(RegisterRequest registerRequest);
}
