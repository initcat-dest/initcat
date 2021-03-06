package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 金币交易流水表
 *
 * @author dest
 * @package com.initcat.user_service.model.db
 * @company xmiles
 * @date 2019/3/24
 */
@Entity
@Data
public class CoinTransRecord implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 操作金币
	 */
	private Integer operateCoin;

    /**
     *交易码
     */
    private Integer transCode;
    /**
     * 交易描述码
     */
    private String transMsg;
	/**
	 * 操作类型 1：充值 ，2：消费
	 */
	private Integer operateType;
	/**
	 * 业务ID
	 */
	private Long businessId;
	/**
	 * 交易后余额
	 */
	private Integer tradeCoin;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
