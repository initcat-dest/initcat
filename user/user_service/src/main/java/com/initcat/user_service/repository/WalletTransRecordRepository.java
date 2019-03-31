package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.WalletTransRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 零钱交易记录Repository
 *
 * @author libo
 * @package com.initcat.repository
 * @company initcat
 * @date 2018/11/26
 */
public interface WalletTransRecordRepository extends JpaRepository<WalletTransRecord, Long> {

	@Query(value = "SELECT * FROM wallet_trans_record WHERE user_id = ?1",
			countQuery = "SELECT count(*) FROM wallet_trans_record WHERE user_id = ?1",
			nativeQuery = true)
	Page<WalletTransRecord> findAllByUserId(Long userID, Pageable pageable);

}
