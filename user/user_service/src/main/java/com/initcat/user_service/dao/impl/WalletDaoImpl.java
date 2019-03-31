package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.WalletDao;
import com.initcat.user_service.model.db.WalletAccountInfo;
import com.initcat.user_service.model.db.WalletTransRecord;
import com.initcat.user_service.repository.WalletAccountInfoRepository;
import com.initcat.user_service.repository.WalletTransRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		return walletAccountInfoRepository.queryByUserId(userId);
	}

	@Override
	public boolean saveTransRecord(Long userId, int operateMoney, int transCode,
								   int operateType, String transMsg, Long businessId, int tradeMoney) {
		WalletTransRecord record = new WalletTransRecord();
		record.setUserId(userId);
		record.setTransMoney(operateMoney);
		record.setOperateType(operateType);
		record.setCreateTime(new Date());
		record.setBusinessId(businessId);
		record.setTransCode(transCode);
		record.setTransMsg(transMsg);
		record.setTradeMoney(tradeMoney);

		walletTransRecordRepository.save(record);
		return record.getId() > 0;
	}

	@Override
	public Page<WalletTransRecord> listTransRecord(Long userId, int pageNum, int pageSize) {
		return walletTransRecordRepository.findByUserId(userId, new PageRequest(pageNum, pageSize));
	}

	@Override
	public void saveAccountInfo(WalletAccountInfo accountInfo) {
		walletAccountInfoRepository.save(accountInfo);
	}

	@Override
	public void updateAccountInfo(WalletAccountInfo accountInfo) {
		walletAccountInfoRepository.save(accountInfo);
	}
}
