package com.initcat.user_service.service.impl.user;

import com.alibaba.fastjson.JSON;
import com.initcat.user_common.model.req.RegisterReq;
import com.initcat.user_common.model.resp.RegisterResp;
import com.initcat.user_common.service.user.UserRegisterService;
import com.initcat.user_service.dao.UserDao;
import com.initcat.user_service.model.db.CommUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户注册service
 *
 * @author libo
 * @package com.initcat.user_service.service.impl.user
 * @company xmiles
 * @date 2019/4/19
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(retries = -1, timeout = 6000)
public class UserRegisterServiceImpl implements UserRegisterService {

    private static Logger logger = LoggerFactory.getLogger(UserRegisterServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public RegisterResp register(RegisterReq registerRequest) {
        logger.info("register start request:{}", JSON.toJSONString(registerRequest));

        String phone = registerRequest.getPhone();
        CommUser commUser = userDao.findByPhone(phone);
        if (commUser != null) {
            return RegisterResp.builder().build();
        }
        return null;
    }
}
