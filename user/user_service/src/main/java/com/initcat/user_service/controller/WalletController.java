package com.initcat.user_service.controller;

import com.initcat.user_common.dto.WalletTransRecordDTO;
import com.initcat.user_common.dto.WalletTransResultDTO;
import com.initcat.user_common.model.req.WalletConsumeReq;
import com.initcat.user_common.model.req.WalletRechargeReq;
import com.initcat.user_common.model.resp.WalletConsumeResp;
import com.initcat.user_common.model.resp.WalletListTransRecordResp;
import com.initcat.user_common.model.resp.WalletRechargeResp;
import com.initcat.user_common.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping("/transList")
	public WalletListTransRecordResp listTransRecord(@RequestParam("userId") Long userId,
													 @RequestParam("pageNum") int pageNum,
													 @RequestParam("pageSize") int pageSize) {
		List<WalletTransRecordDTO> walletTransRecordDTOS = walletService.listTransRecord(userId, pageNum, pageSize);
		WalletListTransRecordResp recordResp = new WalletListTransRecordResp();
		recordResp.setTransRecords(walletTransRecordDTOS);
		return recordResp;
	}

}
