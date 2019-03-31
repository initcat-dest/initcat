package com.initcat.user_service.service;

import com.initcat.user_common.model.dto.CoinTransResultDTO;
import com.initcat.user_common.model.req.CoinConsumeReq;
import com.initcat.user_common.model.req.CoinRechargeReq;


public interface CoinService {
    /**
     * 开户
     * @return
     */
    CoinTransResultDTO openAccount(Long userId);

    /**
     * 充值
     */
    CoinTransResultDTO recharge(CoinRechargeReq coinRechargeReq);

    /**
     * 消费
     */
    CoinTransResultDTO consume(CoinConsumeReq coinConsumeReq);
}
