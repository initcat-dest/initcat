package com.initcat.user_service.service.impl.user;

import com.initcat.common.model.BaseResult;
import com.initcat.user_common.service.user.UserLogoutService;
import org.springframework.stereotype.Service;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_service.service.impl
 * @company xmiles
 * @date 2019/4/18
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(retries = -1, timeout = 6000)
public class UserLogoutServiceImpl implements UserLogoutService {

    @Override
    public BaseResult logOut(String phone) {
        return null;
    }

}
