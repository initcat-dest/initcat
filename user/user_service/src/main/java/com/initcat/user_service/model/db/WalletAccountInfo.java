package com.initcat.user_service.model.db;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name="wallet_account_info")
public class WalletAccountInfo implements Serializable {

	@Id
	@GeneratedValue
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Integer walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
