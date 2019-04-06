package com.initcat.user_service.service.impl;

import com.initcat.user_common.model.dto.SignInInfoDTO;
import com.initcat.user_common.model.dto.SignInResultDTO;
import com.initcat.user_common.service.SignInService;
import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.util.RedisUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.initcat.user_common.model.enums.SignInfoEnum.*;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class SignInServiceImpl implements SignInService {


    @Override
    @Transactional
    public SignInResultDTO signIn(Long userId) {
        SignInInfoDTO info = new SignInInfoDTO();
        CoinAccountInfo coinAccountInfo = new CoinAccountInfo();
        String redisLockKey = "Sign:signIn:" + info.getUserId() + ":" + info.getLastSignTime() + ":" + info.getCountSignDay();
        if (!RedisUtils.setnxex(redisLockKey, "1", 5)) {
            return SignInResultDTO.builder().transResult(REPEAT_REQUEST).build();
        }

        boolean isTodaySignIn = DateUtils.isSameDay(info.getLastSignTime(), new Date());
        if (isTodaySignIn) {
            return SignInResultDTO.builder().transResult(SAVE_RECORD_ERROR).build();
        } else {
            // 今天未签到情况下处理签到
            //1.昨天签到
            boolean isYesterdaySignIn = DateUtils.isSameDay(info.getLastSignTime(),
                    DateUtils.addDays(new Date(), -1));
            if (isYesterdaySignIn) {
                info.setLastSignTime(new Date());
                int i = info.getCountSignDay() + 1;
                info.setCountSignDay(i);
                info.setUpdateTime(new Date());
                switch (info.getCountSignDay()) {
                    case 2:
                        int coinBalance = coinAccountInfo.getCoinBalance() + 20;
                        coinAccountInfo.setCoinBalance(coinBalance);
                        break;
                    case 3:
                        coinBalance = coinAccountInfo.getCoinBalance() + 30;
                        coinAccountInfo.setCoinBalance(coinBalance);
                    case 4:
                        coinBalance = coinAccountInfo.getCoinBalance() + 40;
                        coinAccountInfo.setCoinBalance(coinBalance);
                        break;
                    case 5:
                        coinBalance = coinAccountInfo.getCoinBalance() + 50;
                        coinAccountInfo.setCoinBalance(coinBalance);
                        break;
                    case 6:
                        coinBalance = coinAccountInfo.getCoinBalance() + 60;
                        coinAccountInfo.setCoinBalance(coinBalance);
                        break;
                    default:
                        coinBalance = coinAccountInfo.getCoinBalance() + 70;
                        coinAccountInfo.setCoinBalance(coinBalance);
                        break;
                }

                return SignInResultDTO.builder().transResult(SUCCESS).build();
            } else {
                //2.昨天未签到
                info.setLastSignTime(new Date());
                info.setCountSignDay(1);
                info.setUpdateTime(new Date());
                int coinBalance = coinAccountInfo.getCoinBalance() + 10;
                coinAccountInfo.setCoinBalance(coinBalance);
                return SignInResultDTO.builder().transResult(SUCCESS).build();
            }
        }
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

