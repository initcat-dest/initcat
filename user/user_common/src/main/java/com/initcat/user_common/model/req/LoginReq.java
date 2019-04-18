package com.initcat.user_common.model.req;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录请求对象
 *
 * @author libo
 * @package com.initcat.dto.req
 * @company initcat
 * @date 2018/11/26
 */
@Data
@Builder
public class LoginReq implements Serializable {

    private static final long serialVersionUID = 5891622822819159083L;

    /**
     * 登录手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String passward;

}
