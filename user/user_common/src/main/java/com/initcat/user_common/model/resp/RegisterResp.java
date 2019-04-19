package com.initcat.user_common.model.resp;

import com.initcat.user_common.enums.RegisterStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 注册返回
 *
 * @author libo
 * @package com.initcat.user_common.model.req
 * @company xmiles
 * @date 2019/4/19
 */
@Data
@Builder
public class RegisterResp implements Serializable {

    private static final long serialVersionUID = -2065710829632371215L;

    private boolean registerStatus;

    private RegisterStatusEnum registerStatusEnum;

}
