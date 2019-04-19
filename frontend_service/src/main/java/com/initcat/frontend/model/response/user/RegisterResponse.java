package com.initcat.frontend.model.response.user;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册返回
 *
 * @author libo
 * @package com.initcat.frontend.model.response.user
 * @company xmiles
 * @date 2019/4/19
 */
@Data
@Builder
public class RegisterResponse implements Serializable {

    private static final long serialVersionUID = 4136085367549943862L;

    private boolean registerStatus;

    private String msg;
}
