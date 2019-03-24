package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.WalletTransRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 零钱交易记录Repository
 *
 * @author libo
 * @package com.initcat.repository
 * @company initcat
 * @date 2018/11/26
 */
public interface WalletTransRecordRepository extends JpaRepository<WalletTransRecord, Long> {

	WalletTransRecord findByUserId(Long userId);

	WalletTransRecord findByUserIdForUpdate(Long userId);
}
