package com.initcat.user_service.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 零钱账户表
 *
 * @author libo
 * @package com.initcat.user_service.model.db
 * @company xmiles
 * @date 2019/3/24
 */
@Entity
@Data
public class WalletAccountInfo implements Serializable {

	@Id
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 零钱余额
	 */
	private Integer walletBalance;
	/**
	 * 零钱账户状态 1：有效 ，非1：无效
	 */
	private Integer accountStatus;
	/**
	 * 开户时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
}
