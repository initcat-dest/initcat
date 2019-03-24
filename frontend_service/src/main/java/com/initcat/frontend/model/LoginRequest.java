package com.initcat.frontend.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 登录
 *
 * @author libo
 * @package com.frontend.model
 * @company xmiles
 * @date 2019/3/10
 */
@Data
public class LoginRequest {

	@NotEmpty(message = "登录账号不能为空")
	private String userNumber;

	@NotEmpty(message = "登录密码不能为空")
	private String passward;

	@NotNull(message = "登录账号类型不能为空")
	@Min(value = 0, message = "登录账号类型不正确")
	@Max(value = 2, message = "登录账号类型不正确")
	private Integer userType;
}
