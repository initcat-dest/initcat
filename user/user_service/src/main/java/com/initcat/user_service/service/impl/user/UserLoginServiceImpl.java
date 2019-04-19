package com.initcat.user_service.service.impl.user;

import com.alibaba.fastjson.JSON;
import com.initcat.common.util.UserPasswordUtils;
import com.initcat.user_common.dto.CommUserDTO;
import com.initcat.user_common.model.req.LoginReq;
import com.initcat.user_common.model.resp.LoginResp;
import com.initcat.user_common.service.user.UserLoginService;
import com.initcat.user_service.dao.UserDao;
import com.initcat.user_service.model.db.CommUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.initcat.user_common.enums.LoginStatusEnum.*;

@Service
@com.alibaba.dubbo.config.annotation.Service(retries = -1, timeout = 6000)
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
            // 校验参数
            if (loginReq.getPhone() == null || loginReq.getPassward() == null) {
                loginResp = LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
                return loginResp;
            }
            // 查询commUser
            CommUser commUser = userDao.findByPhone(loginReq.getPhone());
            if (commUser == null) {
                loginResp = LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
                return loginResp;
            }

            // 校验密码
            String dbPassword = commUser.getPassword();
            if (!UserPasswordUtils.validatePassword(dbPassword, loginReq.getPassward())) {
                loginResp = LoginResp.builder().loginStatusEnum(LOGIN_ERROR_PASSWORD).build();
                return loginResp;
            }

            CommUserDTO commUserDTO = new CommUserDTO();
            BeanUtils.copyProperties(commUser, commUserDTO);
            loginResp = LoginResp.builder().commUser(commUserDTO).loginStatusEnum(LOGIN_SUCCESS).build();
        } catch (Exception e) {
            logger.error(">>>login error loginReq:{}", JSON.toJSONString(loginReq), e);
            loginResp = LoginResp.builder().loginStatusEnum(LOGIN_FAIL).build();
        } finally {
            logger.info(">>>login end loginReq:{}; loginResp:{}", JSON.toJSONString(loginReq), JSON.toJSONString(loginResp));
        }
        return loginResp;
    }

}
