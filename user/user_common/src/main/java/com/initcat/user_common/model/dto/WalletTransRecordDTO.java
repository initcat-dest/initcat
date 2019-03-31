package com.initcat.user_common.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_common.model.dto
 * @company xmiles
 * @date 2019/3/31
 */
@Data
public class WalletTransRecordDTO {

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 操作类型 1：充值 ，2：消费
	 */
	private Integer operateType;
	/**
	 * 交易余额（单位：分）
	 */
	private Integer transMoney;
	/**
	 * 交易完成后余额（单位：分）
	 */
	private Integer tradeMoney;
	/**
	 * 交易信息
	 */
	private String transMsg;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
