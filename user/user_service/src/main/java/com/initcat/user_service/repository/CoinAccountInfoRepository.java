package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.CoinAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

/**
 * limingsong
 * 19/3/24
 */
public interface CoinAccountInfoRepository extends JpaRepository<CoinAccountInfo, Long> {

    CoinAccountInfo findByUserId(Long userId);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT cai FROM CoinAccountInfo cai WHERE cai.userId = ?1")
    CoinAccountInfo queryByUserId(Long userId);
}
