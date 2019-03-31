package com.initcat.user_service.service;

import com.initcat.user_common.model.dto.WalletTransResultDTO;
import com.initcat.user_common.model.req.WalletConsumeReq;
import com.initcat.user_common.model.req.WalletRechargeReq;
import com.initcat.user_service.model.db.WalletAccountInfo;

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
	WalletAccountInfo openAccount(Long userId);

	/**
	 * 零钱充值
	 *
	 * @param rechargeReq 零钱充值请求对象
	 * @return walletTransResultDTO
	 */
	WalletTransResultDTO recharge(WalletRechargeReq rechargeReq);

	/**
	 * 零钱消费
	 * @param consumeReq 零钱消费请求对象
	 * @return walletTransResultDTO
	 */
	WalletTransResultDTO consume(WalletConsumeReq consumeReq);
}
