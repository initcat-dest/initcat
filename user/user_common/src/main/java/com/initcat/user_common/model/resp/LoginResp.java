package com.initcat.user_common.model.resp;

import com.initcat.user_common.dto.CommUserDTO;
import com.initcat.user_common.enums.LoginStatusEnum;
import lombok.Builder;
import lombok.Data;

/**
 * 登录返回对象
 * @author libo
 * @package com.initcat.dto.resp
 * @company initcat
 * @date 2018/11/27
 */
@Data
@Builder
public class LoginResp {

    /**
     * 用户信息
     */
    private CommUserDTO commUser;
    /**
     * 登录状态
     */
    private LoginStatusEnum loginStatusEnum;

}
