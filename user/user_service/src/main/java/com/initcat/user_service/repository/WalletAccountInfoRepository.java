package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.WalletAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 零钱账户Repository
 *
 * @author libo
 * @package com.initcat.repository
 * @company initcat
 * @date 2018/11/26
 */
public interface WalletAccountInfoRepository extends JpaRepository<WalletAccountInfo, Long> {

	WalletAccountInfo findByUserId(Long userId);

	WalletAccountInfo findByUserIdForUpdate(Long userId);
}
