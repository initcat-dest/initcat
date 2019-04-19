package com.initcat.user_common.service.user;

import com.initcat.user_common.model.req.RegisterReq;
import com.initcat.user_common.model.resp.RegisterResp;

/**
 * 用户注册service
 *
 * @author libo
 * @package com.initcat.user_common.service.user
 * @company xmiles
 * @date 2019/4/18
 */
public interface UserRegisterService {

    /**
     * 用户注册
     * @param registerRequest 注册请求信息
     * @return RegisterResp
     */
    RegisterResp register(RegisterReq registerRequest);

}
