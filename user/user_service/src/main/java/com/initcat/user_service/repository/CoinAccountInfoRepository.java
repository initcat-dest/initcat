package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.CoinAccountInfo;
import com.initcat.user_service.model.db.CoinTransRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * limingsong
 * 19/3/24
 */
public interface CoinAccountInfoRepository extends JpaRepository<CoinAccountInfo,Long> {


    CoinAccountInfo updateAccount(Long userId);

}
