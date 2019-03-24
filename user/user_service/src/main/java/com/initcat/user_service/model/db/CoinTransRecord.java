package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
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
	 * 操作类型 1：充值 ，2：消费
	 */
	private Integer operateType;
	/**
	 * 交易余额
	 */
	private Integer tradeCoin;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
