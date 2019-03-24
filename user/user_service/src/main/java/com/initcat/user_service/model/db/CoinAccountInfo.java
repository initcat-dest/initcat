package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 金币账户表
 *
 * @author mongku
 * @package com.initcat.user_service.model.db
 * @company xmiles
 * @date 2019/3/24
 */
@Entity
@Data
public class CoinAccountInfo implements Serializable {

	private Long id;
	private Long userId;
	/**
	 * 金币余额
	 */
	private Long coinBalance;
	/**
	 * 金币账户状态 1：有效 ，非1：无效'
	 */
	private Integer accountStatus;
	private Date createTime;
	private Date updateTime;

}
