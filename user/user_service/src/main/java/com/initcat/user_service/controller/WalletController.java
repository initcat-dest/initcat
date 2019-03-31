package com.initcat.user_service.controller;

import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_common.model.req.WalletConsumeReq;
import com.initcat.user_common.model.req.WalletRechargeReq;
import com.initcat.user_common.model.resp.WalletConsumeResp;
import com.initcat.user_common.model.resp.WalletRechargeResp;
import com.initcat.user_common.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 零钱账户Controller
 *
 * @author libo
 * @package com.initcat.user_service.controller
 * @company xmiles
 * @date 2019/3/31
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletService;

	@PostMapping("recharge")
	public WalletRechargeResp recharge(@RequestBody WalletRechargeReq rechargeReq) {
		WalletTransResultDTO rechargeResult = walletService.recharge(rechargeReq);
		WalletRechargeResp rechargeResp = new WalletRechargeResp();
		rechargeResp.setRechargeResult(rechargeResult);
		return rechargeResp;
	}

	@PostMapping("/consume")
	@ResponseBody
	public WalletConsumeResp consume(@RequestBody WalletConsumeReq consumeReq) {
		WalletTransResultDTO consumeResult = walletService.consume(consumeReq);
		WalletConsumeResp consumeResp = new WalletConsumeResp();
		consumeResp.setConsumeResult(consumeResult);
		return consumeResp;
	}

//	@PostMapping("/consume")
//	@ResponseBody
//	public WalletConsumeResp listTransRecord(@RequestBody WalletConsumeReq consumeReq) {
//		WalletTransResultDTO consumeResult = walletService.listTransRecord(consumeReq);
//		WalletConsumeResp consumeResp = new WalletConsumeResp();
//		consumeResp.setConsumeResult(consumeResult);
//		return consumeResp;
//	}

}
