package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 零钱交易流水表
 *
 * @author libo
 * @package com.initcat.user_service.model.db
 * @company xmiles
 * @date 2019/3/24
 */
@Entity
@Data
public class WalletTransRecord implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
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
	 * 交易码
	 */
	private Integer transCode;
	/**
	 * 交易信息
	 */
	private String transMsg;
	/**
	 * 业务ID
	 */
	private Long businessId;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
