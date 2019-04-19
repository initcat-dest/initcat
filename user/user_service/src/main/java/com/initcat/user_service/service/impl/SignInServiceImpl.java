package com.initcat.user_service.service.impl;

import com.initcat.user_common.dto.SignInResultDTO;
import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.service.CoinService;
import com.initcat.user_common.service.SignInService;
import com.initcat.user_service.dao.SignInDao;
import com.initcat.user_service.model.db.SignInInfo;
import com.initcat.user_service.util.RedisUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.initcat.user_common.enums.SignInStatusEnum.*;


@Service
@com.alibaba.dubbo.config.annotation.Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    CoinService coinService;

    @Autowired
    SignInDao signInDao;

    @Override
    @Transactional
    public SignInResultDTO signIn(Long userId) {

        // 这里定义了缓存key名称，给id进行加锁
        String redisLockKey = "signIn:lock:" + userId;
        if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
            return SignInResultDTO.builder().signInResult(REPEAT_REQUEST).build();
        }

        // 获取用户签到信息，没有就初始化用户签到信息
        // forUpdate是用来防止数据操作时出现错误，用了之后可以先将数据锁住然后判断是执行什么业务最后进行更新，
        // 即一锁二断三更
        // 所以签到不适合用到forUpdate

        // 查询用户签到信息
        SignInInfo signInInfo = getUserSignInfoWithInit(userId);

        // 判断用户今日是否签到
        boolean isTodaySignIn = DateUtils.isSameDay(signInInfo.getLastSignTime(), new Date());
        if (isTodaySignIn) {
            return SignInResultDTO.builder().signInResult(REPEAT_REQUEST).build();
        } else {
            // 判断用户是否连续签到
            boolean isYesterdaySignIn = DateUtils.isSameDay(signInInfo.getLastSignTime(),
                    DateUtils.addDays(new Date(), -1));
            CoinRechargeReq coinRechargeReq = new CoinRechargeReq();
            if (isYesterdaySignIn) {
                // 1.连续签到
                // 修改最后签到时间
                signInInfo.setLastSignTime(new Date());
                // 修改连续签到时间
                int countSignDay = signInInfo.getCountSignDay() + 1;
                signInInfo.setCountSignDay(countSignDay);
                signInInfo.setUpdateTime(new Date());
                // 加金币
                int signInAwardCoin = getSignInAwardCoin(countSignDay);
                coinRechargeReq.setUserId(userId);
                coinRechargeReq.setRechargeCoin(signInAwardCoin);
                coinRechargeReq.setTransCode(1);
                coinService.recharge(coinRechargeReq);
                signInDao.updateSignInInfo(signInInfo);
                return SignInResultDTO.builder().signInResult(SUCCESS).build();
            } else {
                // 2.连续签到中断或从未签到
                // 修改最后签到时间
                signInInfo.setLastSignTime(new Date());
                // 连续签到时间改为1
                signInInfo.setCountSignDay(1);
                // 加金币
                coinRechargeReq.setUserId(userId);
                int signInAwardCoin = getSignInAwardCoin(signInInfo.getCountSignDay());
                coinRechargeReq.setRechargeCoin(signInAwardCoin);
                coinRechargeReq.setTransCode(1);
                coinService.recharge(coinRechargeReq);
                signInDao.updateSignInInfo(signInInfo);
                signInInfo.setUpdateTime(new Date());
                signInDao.updateSignInInfo(signInInfo);
                return SignInResultDTO.builder().signInResult(SUCCESS).build();
            }
        }
    }

    private SignInInfo getUserSignInfoWithInit(Long userId) {
        SignInInfo userSignInfo = getUserSignInfo(userId);
        if (userSignInfo == null) {
            userSignInfo = new SignInInfo();
            userSignInfo.setUserId(userId);
            // 连续签到时间为0
            userSignInfo.setCountSignDay(0);
            // 默认给其最后签到时间为前一天
            userSignInfo.setLastSignTime(DateUtils.addDays(new Date(), 1));
            userSignInfo.setCreateTime(new Date());
            userSignInfo.setUpdateTime(new Date());
            coinService.openAccount(userId);
            signInDao.insertInfo(userSignInfo);
        }
        return userSignInfo;
    }

    private SignInInfo getUserSignInfo(Long userId) {
        // 查询用户签到信息
        return signInDao.findSignInInfo(userId);
    }

    private int getSignInAwardCoin(int countSignDay) {
        return countSignDay <= 7 ? countSignDay * 10 : 70;
    }

}

