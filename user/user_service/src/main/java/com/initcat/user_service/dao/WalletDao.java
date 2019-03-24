package com.initcat.user_service.dao;

import com.initcat.user_service.model.db.WalletAccountInfo;

/**
 *
 */
public interface WalletDao {

	WalletAccountInfo findByUserId(Long userId);

	WalletAccountInfo findByUserIdForUpdate(Long userId);

	boolean saveTransRecord(Long userId, int operateMoney, int transCode,
							int operateType, String transMsg, Long businessId, int tradeMoney);

	void updateAccountInfo(WalletAccountInfo accountInfo);
}
