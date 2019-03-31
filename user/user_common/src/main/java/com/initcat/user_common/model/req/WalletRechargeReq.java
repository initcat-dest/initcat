package com.initcat.user_common.model.req;

import lombok.Data;

/**
 * 零钱充值请求对象
 *
 * @author libo
 * @package com.initcat.user_common.model.req
 * @company xmiles
 * @date 2019/3/31
 */
@Data
public class WalletRechargeReq {
	/**
	 * 请求userID
	 */
	private Long userId;
	/**
	 * 交易码
	 */
	private int transCode;
	/**
	 * 交易描述
	 */
	private String transMsg;
	/**
	 * 充值金额（单位：分）
	 */
	private int rechargeMoney;
	/**
	 * 业务ID
	 */
	private Long businessId;

}
