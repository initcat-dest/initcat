package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.CoinTransRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinTransRecordRepository extends JpaRepository<CoinTransRecord,Long> {
    CoinTransRecord updateTrans(Long userId);
}
