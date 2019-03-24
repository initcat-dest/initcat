package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.WalletAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

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

	@Lock(value = LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT wai FROM WalletAccountInfo wai WHERE wai.userId = ?1")
	WalletAccountInfo queryByUserId(Long userId);
}
