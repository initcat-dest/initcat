package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.SignInResultDTO;
import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.model.req.SignInReq;
import com.initcat.user_common.service.CoinService;
import com.initcat.user_common.service.SignInService;
import com.initcat.user_service.dao.SignInDao;
import com.initcat.user_service.model.db.SignInInfo;
import com.initcat.user_service.util.RedisUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.initcat.user_common.model.enums.SignInfoEnum.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    CoinService coinService;
    @Autowired
    SignInDao signInDao;

    @Override
    @Transactional
    public SignInResultDTO signIn(SignInReq signInReq) {
        String redisLockKey = "Sign:signIn:" + signInReq.getUserId();
        if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
            // TODO song 定义变量名
            return SignInResultDTO.builder().transResult(REPEAT_REQUEST).build();
        }
        //获取用户信息并加锁
        // TODO song 思考为什么不需要forUpdate - 不需要forUpdate
        SignInInfo signInInfo = getUserSignInfoWithInit(signInReq.getUserId());

        boolean isTodaySignIn = DateUtils.isSameDay(signInReq.getLastSignTime(), new Date());
        if (isTodaySignIn) {
            return SignInResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
        } else {
            // 今天未签到情况下处理签到
            //1.昨天签到
            boolean isYesterdaySignIn = DateUtils.isSameDay(signInReq.getLastSignTime(),
                    DateUtils.addDays(new Date(), -1));
            if (isYesterdaySignIn) {
                signInReq.setLastSignTime(new Date());
                int countSignDay = signInReq.getCountSignDay() + 1;
                signInReq.setCountSignDay(countSignDay);
                signInReq.setUpdateTime(new Date());
                int signInAwardCoin = getSignInAwardCoin(countSignDay);
                CoinRechargeReq coinRechargeReq = new CoinRechargeReq();
                coinRechargeReq.setRechargeCoin(signInAwardCoin);
                coinService.recharge(coinRechargeReq);
                signInDao.updateAccountInfo(signInInfo);
                return SignInResultDTO.builder().transResult(SUCCESS).build();
            } else {
                //2.昨天未签到或从未签到
                signInReq.setLastSignTime(new Date());
                signInReq.setCountSignDay(1);
                signInReq.setUpdateTime(new Date());
                signInDao.updateAccountInfo(signInInfo);
                return SignInResultDTO.builder().transResult(SUCCESS).build();
            }
        }
    }

    private int getSignInAwardCoin(int countSignDay) {
        return countSignDay <= 7 ? countSignDay * 10 : 70;
//
//        switch (signInReq.getCountSignDay()) {
//            case 2:
//                signInAwardCoin = 20;
//                break;
//            case 3:
//                signInAwardCoin = 30;
//                break;
//            case 4:
//                signInAwardCoin = 40;
//                break;
//            case 5:
//                signInAwardCoin = 50;
//                break;
//            case 6:
//                signInAwardCoin = 60;
//                break;
//            default:
//                signInAwardCoin = 70;
//                break;
//        }
//        return signInAwardCoin;
    }

    public static void main(String[] args) {
        //比较日期
        Date date = DateUtils.addDays(new Date(), -1);
        String format = DateFormatUtils.format(date, "yyyy-MM-dd");
        //日期把格式转换为年月日
        System.out.println(format);
        // SimpleDateFormat
    }
}

