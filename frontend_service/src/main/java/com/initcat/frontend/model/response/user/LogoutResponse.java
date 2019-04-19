package com.initcat.frontend.model.response.user;

import lombok.Builder;
import lombok.Data;

/**
 * 登出返回信息
 *
 * @author libo
 * @package com.initcat.frontend.model.response
 * @company xmiles
 * @date 2019/4/18
 */
@Data
@Builder
public class LogoutResponse {

    private boolean logoutStatus;

    private String msg;
}
