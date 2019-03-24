package com.initcat.user_service.dao;

import com.initcat.user_service.model.db.WalletAccountInfo;

/**
 * 零钱Dao
 */
public interface WalletDao {

	/**
	 * 开户
	 */
	void saveAccountInfo(WalletAccountInfo accountInfo);

	/**
	 * 更新账户
	 */
	void updateAccountInfo(WalletAccountInfo accountInfo);

	/**
	 * 根据用户ID获取零钱账户信息
	 *
	 * @param userId 用户信息
	 * @return 账户信息
	 */
	WalletAccountInfo findByUserId(Long userId);

	/**
	 * 根据用户ID获取零钱账户信息，并进行行锁
	 *
	 * @param userId 用户信息
	 * @return 账户信息
	 */
	WalletAccountInfo findByUserIdForUpdate(Long userId);

	/**
	 * 保存交易流水
	 *
	 * @param userId       用户ID
	 * @param operateMoney 修改金额
	 * @param transCode    交易码
	 * @param operateType  操作类型
	 * @param transMsg     交易描述
	 * @param businessId   业务ID
	 * @param tradeMoney   完成交易后余额
	 * @return
	 */
	boolean saveTransRecord(Long userId, int operateMoney, int transCode,
							int operateType, String transMsg, Long businessId, int tradeMoney);


}
