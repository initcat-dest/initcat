package com.initcat.user_service.controller;

import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_common.model.req.WalletConsumeReq;
import com.initcat.user_common.model.req.WalletRechargeReq;
import com.initcat.user_common.model.resp.WalletConsumeResp;
import com.initcat.user_common.model.resp.WalletRechargeResp;
import com.initcat.user_service.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/recharge")
	public WalletRechargeResp recharge(@RequestBody WalletRechargeReq recargeReq) {
		WalletTransResultDTO rechargeResult = walletService.recharge(recargeReq);
		WalletRechargeResp rechargeResp = new WalletRechargeResp();
		rechargeResp.setRechargeResult(rechargeResult);
		return rechargeResp;
	}

	@PostMapping("/consume")
	public WalletConsumeResp consume(@RequestBody WalletConsumeReq consumeReq) {
		WalletTransResultDTO consumeResult = walletService.consume(consumeReq);
		WalletConsumeResp consumeResp = new WalletConsumeResp();
		consumeResp.setConsumeResult(consumeResult);
		return consumeResp;
	}

}
