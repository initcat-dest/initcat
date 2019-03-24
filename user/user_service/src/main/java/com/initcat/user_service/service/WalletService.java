package com.initcat.user_service.service;

import com.initcat.user_common.model.dto.walletTransResultDTO;
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
	 * @param userId        用户ID
	 * @param transCode     交易码
	 * @param transMsg      交易描述
	 * @param rechargeMoney 交易金额（单位：分）
	 * @param businessId    业务ID
	 * @return walletTransResultDTO
	 */
	walletTransResultDTO recharge(Long userId, int transCode, String transMsg, int rechargeMoney, Long businessId);

	/**
	 * 零钱消费
	 *
	 * @param userId       用户ID
	 * @param transCode    交易码
	 * @param transMsg     交易描述
	 * @param consumeMoney 消费金额（单位：分）
	 * @param businessId   业务ID
	 * @return walletTransResultDTO
	 */
	walletTransResultDTO consume(Long userId, int transCode, String transMsg, int consumeMoney, Long businessId);
}
