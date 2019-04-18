package com.initcat.user_service.service.impl.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.initcat.user_common.model.dto.CommUserDTO;
import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.model.resp.LoginResp;
import com.initcat.user_common.service.user.UserLoginService;
import com.initcat.user_service.dao.UserDao;
import com.initcat.user_service.model.db.CommUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.initcat.user_common.model.enums.LoginStatusEnum.LOGIN_FAIL;
import static com.initcat.user_common.model.enums.LoginStatusEnum.LOGIN_SUCCESS;

@Component
@Service(retries = -1, timeout = 6000)
public class UserLoginServiceImpl implements UserLoginService {

    private static Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Override
    public LoginResp login(LoginReq loginReq) {

        // TODO dest 使用公共组件校验入参; 校验密码组件; 单点登录; 自动生成用户数据; Redis HyperLogLog 统计
        logger.info(">>>login start loginReq:{}", JSON.toJSONString(loginReq));
        LoginResp loginResp = null;
        try {
            // Thread.sleep(6000);

            if (loginReq.getPhone() == null || loginReq.getPassward() == null) {
                loginResp = LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
                return loginResp;
            }

            CommUser commUser = userDao.findByPhone(loginReq.getPhone());
            if (commUser == null) {
                loginResp = LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
                return loginResp;
            }

            CommUserDTO commUserDTO = new CommUserDTO();
            BeanUtils.copyProperties(commUser, commUserDTO);
            loginResp = LoginResp.builder().commUser(commUserDTO).loginStatusEnum(LOGIN_SUCCESS).build();
        } catch (Exception e) {
            logger.error(">>>login error:" + JSON.toJSONString(loginReq), e);
            loginResp = LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
        } finally {
            logger.info(">>>login end loginReq:{}; loginResp:{}", JSON.toJSONString(loginReq), JSON.toJSONString(loginResp));
        }
        return loginResp;
    }

}
