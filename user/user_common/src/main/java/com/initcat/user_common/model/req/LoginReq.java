package com.initcat.user_common.model.req;

import lombok.Data;

/**
 * 登录请求对象
 * @author libo
 * @package com.initcat.dto.req
 * @company initcat
 * @date 2018/11/26
 */
@Data
public class LoginReq {

    /**
     * 登录手机号
     */
    private String phone;
    /**
     * 登录密码
     */
    private String passward;

}
