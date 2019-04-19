package com.initcat.frontend.model.request.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求对象
 *
 * @author libo
 * @package com.initcat.frontend.model.request.user
 * @company xmiles
 * @date 2019/4/19
 */
@Data
public class RegisterRequest implements Serializable {

    private static final long serialVersionUID = -4931241425038479419L;

    /**
     * 登录手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String passward;
}
