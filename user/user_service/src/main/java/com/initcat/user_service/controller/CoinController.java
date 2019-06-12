package com.initcat.user_service.controller;

import com.initcat.user_common.dto.CoinTransRecordDTO;
import com.initcat.user_common.dto.CoinTransResultDTO;
import com.initcat.user_common.model.req.CoinConsumeReq;
import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.model.resp.CoinConsumeResp;
import com.initcat.user_common.model.resp.CoinListTransRecordResp;
import com.initcat.user_common.model.resp.CoinRechargeResp;
import com.initcat.user_common.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {

    @Autowired
    CoinService coinService;

    @PostMapping("/recharge")
    public CoinRechargeResp recharge(@RequestBody CoinRechargeReq coinRechargeReq) {
        CoinTransResultDTO rechargeResult = coinService.recharge(coinRechargeReq);
        CoinRechargeResp coinRechargeResp = new CoinRechargeResp();
        coinRechargeResp.setRechargeResult(rechargeResult);
        return coinRechargeResp;
    }

    @PostMapping("/consume")
    public CoinConsumeResp consume(@RequestBody CoinConsumeReq coinConsumeReq) {
        CoinTransResultDTO consumeResult = coinService.consume(coinConsumeReq);
        CoinConsumeResp coinConsumeResp = new CoinConsumeResp();
        coinConsumeResp.setConsumeResult(consumeResult);
        return coinConsumeResp;
    }

    @GetMapping("/listTransRecord")
    @ResponseBody
    public CoinListTransRecordResp listTransRecord(@RequestParam("userId") Long userId,
                                                   @RequestParam("pageNum") int pageNum,
                                                   @RequestParam("pageSize") int pageSize) {
        List<CoinTransRecordDTO> coinTransRecordDTOS =  coinService.listTransRecord(userId, pageNum, pageSize);
        CoinListTransRecordResp coinListTransRecordResp = new CoinListTransRecordResp();
        coinListTransRecordResp.setTransRecords(coinTransRecordDTOS);
        return coinListTransRecordResp;
    }

    @GetMapping("/testOOM")
    public void testOOM() {
        for (int i = 0; i < 1000000 ; i++) {
            String a = new String("testOOM");
        }
    }

}
