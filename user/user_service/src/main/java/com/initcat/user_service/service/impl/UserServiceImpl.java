package com.initcat.user_service.service.impl;

import com.alibaba.druid.util.HttpClientUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.initcat.user_common.model.dto.CommUserDTO;
import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.model.resp.LoginResp;
import com.initcat.user_common.service.UserService;
import com.initcat.user_service.dao.UserDao;
import com.initcat.user_service.model.db.CommUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.initcat.user_common.model.enums.LoginStatusEnum.LOGIN_FAIL;
import static com.initcat.user_common.model.enums.LoginStatusEnum.LOGIN_SUCCESS;

@Service
@Component
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    @Autowired
    UserDao userDao;

    @Override
    public LoginResp login(LoginReq loginReq) {
        // TODO 使用公共组件校验入参
        // TODO 校验密码组件
        // TODO 单点登录
        // TODO 自动生成用户数据
        // TODO Redis HyperLogLog 统计
        try {
            logger.info(">>>>>login start:" + (loginReq != null ? loginReq.toString() : "null"));
            CommUser commUser = userDao.findByPhone(loginReq.getPhone());
            CommUserDTO commUserDTO = new CommUserDTO();
            if (commUser != null) {
				BeanUtils.copyProperties(commUser, commUserDTO);
				return LoginResp.builder().commUser(commUserDTO).loginStatusEnum(LOGIN_SUCCESS).build();
			} else {
				return LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
			}
        } catch (Exception e) {
            logger.error(">>>>>login:" + (loginReq != null ? loginReq.toString() : "null"), e);
            return LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
        }
    }

    @Override
    public CommUserDTO logOut(String userPhone) {
		logger.info(">>>>logOut-test");
		return null;
    }


}
