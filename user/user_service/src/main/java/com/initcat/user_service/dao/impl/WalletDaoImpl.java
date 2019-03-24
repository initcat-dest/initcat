package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.WalletDao;
import com.initcat.user_service.model.db.WalletAccountInfo;
import com.initcat.user_service.model.db.WalletTransRecord;
import com.initcat.user_service.repository.WalletAccountInfoRepository;
import com.initcat.user_service.repository.WalletTransRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_service.dao.impl
 * @company xmiles
 * @date 2019/3/24
 */
@Repository
public class WalletDaoImpl implements WalletDao {

	@Autowired
	WalletAccountInfoRepository walletAccountInfoRepository;
	@Autowired
	WalletTransRecordRepository walletTransRecordRepository;

	@Override
	public WalletAccountInfo findByUserId(Long userId) {
		return walletAccountInfoRepository.findByUserId(userId);
	}

	@Override
	public WalletAccountInfo findByUserIdForUpdate(Long userId) {
		return walletAccountInfoRepository.findByUserIdForUpdate(userId);
	}

	@Override
	public boolean saveTransRecord(Long userId, int operateMoney, int transCode,
								   int operateType,  String transMsg, Long businessId, int tradeMoney) {
		WalletTransRecord record = new WalletTransRecord();
		record.setUserId(userId);
		record.setOperateMoney(operateMoney);
		record.setTradeMoney(tradeMoney);
		record.setOperateType(operateType);
		record.setCreateTime(new Date());
		record.setBusinessId(businessId);
		record.setTradeCode(transCode);
		record.setTradeMsg(transMsg);

		walletTransRecordRepository.save(record);
		// TODO
		return true;
	}

	@Override
	public void updateAccountInfo(WalletAccountInfo accountInfo) {
		walletAccountInfoRepository.save(accountInfo);
	}
}
