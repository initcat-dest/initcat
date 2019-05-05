package com.initcat.frontend.model.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "登录请求信息")
public class LoginRequest {

	@ApiModelProperty(value = "登录手机号")
	@NotEmpty(message = "登录账号不能为空")
	private String phone;

	@ApiModelProperty(value = "登录密码")
	@NotEmpty(message = "登录密码不能为空")
	private String passward;

}
