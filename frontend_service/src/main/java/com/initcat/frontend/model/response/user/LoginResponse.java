package com.initcat.frontend.model.response.user;

import com.initcat.user_common.dto.CommUserDTO;
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
public class LoginResponse {

	private boolean loginStatus;

	private String msg;

	private CommUserDTO commUserInfo;

}
