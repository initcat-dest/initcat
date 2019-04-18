package com.initcat.frontend.model.request.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登出请求信息
 *
 * @author libo
 * @package com.frontend.model
 * @company xmiles
 * @date 2019/3/10
 */
@Data
public class LogoutRequest {

	@NotEmpty(message = "登出手机号不能为空")
	private String phone;

}
