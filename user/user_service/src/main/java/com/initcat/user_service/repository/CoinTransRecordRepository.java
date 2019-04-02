package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.CoinTransRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoinTransRecordRepository extends JpaRepository<CoinTransRecord,Long> {
    @Query(value = "SELECT * FROM coin_trans_record WHERE user_id = ?1",
            // TODO song wallet_trans_record 表名没有修改
            countQuery = "SELECT count(*) FROM wallet_trans_record WHERE user_id = ?1",
            nativeQuery = true)
    Page<CoinTransRecord> findAllByUserId(Long userID, Pageable pageable);
}
