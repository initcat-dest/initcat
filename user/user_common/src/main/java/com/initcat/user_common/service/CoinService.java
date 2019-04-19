package com.initcat.user_common.service;

import com.initcat.user_common.dto.CoinTransRecordDTO;
import com.initcat.user_common.dto.CoinTransResultDTO;
import com.initcat.user_common.model.req.CoinConsumeReq;
import com.initcat.user_common.model.req.CoinRechargeReq;

import java.util.List;


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

    List<CoinTransRecordDTO> listTransRecord(Long userId, int pageNum, int pageSize);
}
