package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.CoinAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * limingsong
 * 19/3/24
 */
public interface CoinAccountInfoRepository extends JpaRepository<CoinAccountInfo, Long> {

    CoinAccountInfo findByUserId(Long userId);

    CoinAccountInfo updateByUserId(CoinAccountInfo coinAccountInfo);

    CoinAccountInfo findByUserIdForUpdate(Long userId);

}
