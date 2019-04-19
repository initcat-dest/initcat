package com.initcat.user_common.model.req;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 注册请求对象
 *
 * @author libo
 * @package com.initcat.user_common.model.req
 * @company xmiles
 * @date 2019/4/19
 */
@Data
@Builder
public class RegisterReq implements Serializable {

    private static final long serialVersionUID = -8784713162721503321L;

    /**
     * 登录手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String passward;
}
