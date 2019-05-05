package com.initcat.frontend.model.response.user;

import com.initcat.user_common.dto.CommUserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 登录返回信息
 *
 * @author libo
 * @package com.frontend.model
 * @company xmiles
 * @date 2019/3/10
 */
@Data
@Builder
@ApiModel(value = "登录返回信息")
public class LoginResponse {

	@ApiModelProperty(value = "登录状态")
	private boolean loginStatus;
	@ApiModelProperty(value = "登录状态描述")
	private String msg;
	@ApiModelProperty(value = "用户信息")
	private CommUserDTO commUserInfo;

}
