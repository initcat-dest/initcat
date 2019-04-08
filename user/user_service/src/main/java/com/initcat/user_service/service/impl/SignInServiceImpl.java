package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.SignInResultDTO;
import com.initcat.user_common.service.CoinService;
import com.initcat.user_common.service.SignInService;
import com.initcat.user_service.dao.SignInDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // TODO song 临时返回null 写代码的时候删除
        return null;
//        // TODO song 这里我重新定义了缓存key名称
//        String redisLockKey = "signIn:lock:" + userId;
//        if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
//            // TODO song 定义变量名
//            return SignInResultDTO.builder().transResult(REPEAT_REQUEST).build();
//        }
//        //获取用户信息并加锁
//        // TODO song 思考为什么不需要forUpdate - 不需要forUpdate
//        SignInInfo signInInfo = null;// getUserSignInfoWithInit(signInReq.getUserId());
//
//        boolean isTodaySignIn = DateUtils.isSameDay(signInInfo.getLastSignTime(), new Date());
//        if (isTodaySignIn) {
//            return SignInResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
//        } else {
//            // 今天未签到情况下处理签到
//            //1.昨天签到
//            boolean isYesterdaySignIn = DateUtils.isSameDay(signInInfo.getLastSignTime(),
//                    DateUtils.addDays(new Date(), -1));
//            if (isYesterdaySignIn) {
//                signInInfo.setLastSignTime(new Date());
//                int countSignDay = signInReq.getCountSignDay() + 1;
//                signInReq.setCountSignDay(countSignDay);
//                signInReq.setUpdateTime(new Date());
//                int signInAwardCoin = getSignInAwardCoin(countSignDay);
//                CoinRechargeReq coinRechargeReq = new CoinRechargeReq();
//                coinRechargeReq.setRechargeCoin(signInAwardCoin);
//                coinService.recharge(coinRechargeReq);
//                signInDao.updateAccountInfo(signInInfo);
//                return SignInResultDTO.builder().transResult(SUCCESS).build();
//            } else {
//                //2.昨天未签到或从未签到
//                signInReq.setLastSignTime(new Date());
//                signInReq.setCountSignDay(1);
//                signInReq.setUpdateTime(new Date());
//                signInDao.updateAccountInfo(signInInfo);
//                return SignInResultDTO.builder().transResult(SUCCESS).build();
//            }
//        }
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

}

