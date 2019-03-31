package com.initcat.user_common.model.req;

import lombok.Data;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_common.model.req
 * @company xmiles
 * @date 2019/3/31
 */
@Data
public class WalletConsumeReq {
	/**
	 * 用户ID
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
	 * 消费金额（单位：分）
	 */
	private int consumeMoney;
	/**
	 * 业务ID
	 */
	private Long businessId;
}
