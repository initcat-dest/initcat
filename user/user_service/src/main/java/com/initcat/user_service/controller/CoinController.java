package com.initcat.user_service.controller;

import com.initcat.user_common.model.dto.CoinTransResultDTO;
import com.initcat.user_common.model.req.CoinConsumeReq;
import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.model.resp.CoinConsumeResp;
import com.initcat.user_common.model.resp.CoinRechargeResp;
import com.initcat.user_service.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin")
public class CoinController {
    @Autowired
    CoinService coinService;

    @RequestMapping("/recharge")
    @ResponseBody
    public CoinRechargeResp recharge(@RequestBody CoinRechargeReq coinRechargeReq) {
        CoinTransResultDTO rechargeResult = coinService.recharge(coinRechargeReq);
        CoinRechargeResp coinRechargeResp = new CoinRechargeResp();
        coinRechargeResp.setRechargeResult(rechargeResult);
        return coinRechargeResp;
    }

    @RequestMapping("/consume")
    @ResponseBody
    public CoinConsumeResp consume(@RequestBody CoinConsumeReq coinConsumeReq) {
        CoinTransResultDTO consumeResult = coinService.consume(coinConsumeReq);
        CoinConsumeResp coinConsumeResp = new CoinConsumeResp();
        coinConsumeResp.setConsumeResult(consumeResult);
        return coinConsumeResp;
    }
}
