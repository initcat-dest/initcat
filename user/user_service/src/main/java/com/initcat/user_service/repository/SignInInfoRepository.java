package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.SignInInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

public interface SignInInfoRepository extends JpaRepository<SignInInfo, Integer> {
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT cai from SignInInfo cai where cai.userId=?1")
    SignInInfo findById(Long userId);
}
