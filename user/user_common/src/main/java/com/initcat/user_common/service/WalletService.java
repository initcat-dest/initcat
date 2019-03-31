package com.initcat.user_common.service;

import com.initcat.user_common.model.dto.WalletAccountInfoDTO;
import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_common.model.req.WalletConsumeReq;
import com.initcat.user_common.model.req.WalletRechargeReq;

/**
 * 零钱账户service
 *
 * @author libo
 * @package com.initcat.user_service.service
 * @company xmiles
 * @date 2019/3/24
 */
public interface WalletService {

	/**
	 * 开户
	 *
	 * @return 账户信息
	 */
	WalletAccountInfoDTO openAccountForView(Long userId);

	/**
	 * 零钱充值
	 *
	 * @param rechargeReq 零钱充值请求对象
	 * @return walletTransResultDTO
	 */
	WalletTransResultDTO recharge(WalletRechargeReq rechargeReq);

	/**
	 * 零钱消费
	 *
	 * @param consumeReq 零钱消费请求对象
	 * @return walletTransResultDTO
	 */
	WalletTransResultDTO consume(WalletConsumeReq consumeReq);

	/**
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	void listTransRecord(Long userId, int pageNum, int pageSize);
}