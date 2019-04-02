package com.initcat.user_service.controller;

import com.initcat.user_common.model.dto.CoinTransRecordDTO;
import com.initcat.user_common.model.dto.CoinTransResultDTO;
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

    // TODO song MVC不能直接使用RequestMapping,应该根据相应的操作使用 https://www.cnblogs.com/nelson-hu/p/8556422.html
    @RequestMapping("/recharge")
    @ResponseBody
    public CoinRechargeResp recharge(@RequestBody CoinRechargeReq coinRechargeReq) {
        CoinTransResultDTO rechargeResult = coinService.recharge(coinRechargeReq);
        CoinRechargeResp coinRechargeResp = new CoinRechargeResp();
        coinRechargeResp.setRechargeResult(rechargeResult);
        return coinRechargeResp;
    }

    // TODO song MVC不能直接使用RequestMapping,应该根据相应的操作使用 https://www.cnblogs.com/nelson-hu/p/8556422.html
    @RequestMapping("/consume")
    @ResponseBody
    public CoinConsumeResp consume(@RequestBody CoinConsumeReq coinConsumeReq) {
        CoinTransResultDTO consumeResult = coinService.consume(coinConsumeReq);
        CoinConsumeResp coinConsumeResp = new CoinConsumeResp();
        coinConsumeResp.setConsumeResult(consumeResult);
        return coinConsumeResp;
    }

    // TODO song MVC不能直接使用RequestMapping,应该根据相应的操作使用 https://www.cnblogs.com/nelson-hu/p/8556422.html
    @RequestMapping("/listTransRecord")
    @ResponseBody
    public CoinListTransRecordResp listTransRecord(@RequestParam("userId") Long userId,
                                                   @RequestParam("pageNum") int pageNum,
                                                   @RequestParam("pageSize") int pageSize) {
        List<CoinTransRecordDTO> coinTransRecordDTOS =  coinService.listTransRecord(userId, pageNum, pageSize);
        CoinListTransRecordResp coinListTransRecordResp = new CoinListTransRecordResp();
        coinListTransRecordResp.setTransRecords(coinTransRecordDTOS);
        return coinListTransRecordResp;
    }

}