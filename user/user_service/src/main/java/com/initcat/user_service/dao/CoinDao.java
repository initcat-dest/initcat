package com.initcat.user_service.dao;

import com.initcat.user_service.model.db.CoinAccountInfo;

public interface CoinDao {
    /**
     * 根据用户ID获取零钱账户信息，并进行行锁
     *
     * @param userId 用户信息
     * @return 账户信息
     */
    CoinAccountInfo findByUserIdForUpdate(Long userId);

}
