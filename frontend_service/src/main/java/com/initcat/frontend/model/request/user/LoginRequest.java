package com.initcat.frontend.model.request.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录请求信息
 *
 * @author libo
 * @package com.frontend.model
 * @company xmiles
 * @date 2019/3/10
 */
@Data
public class LoginRequest {

	@NotEmpty(message = "登录账号不能为空")
	private String phone;

	@NotEmpty(message = "登录密码不能为空")
	private String passward;

}
