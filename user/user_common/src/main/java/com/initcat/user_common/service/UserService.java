package com.initcat.user_common.service;


import com.initcat.user_common.model.dto.CommUserDTO;
import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.model.resp.LoginResp;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user.service
 * @company xmiles
 * @date 2018/12/10
 */
public interface UserService {

    /**
     * 登录
     * @param loginReq 登录请求信息
     * @return 登录结果
     */
    LoginResp login(LoginReq loginReq);

    /**
     * 登出
     * @param userPhone 用户手机号
     * @return 用户信息
     */
    CommUserDTO logOut(String userPhone);

}
