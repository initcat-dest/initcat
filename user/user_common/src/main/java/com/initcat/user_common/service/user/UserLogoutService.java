package com.initcat.user_common.service.user;


import com.initcat.common.model.BaseResult;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user.service
 * @company xmiles
 * @date 2018/12/10
 */
public interface UserLogoutService {

    /**
     * 登出
     * @param phone 手机号
     * @return 用户信息
     */
    BaseResult logOut(String phone);

}
