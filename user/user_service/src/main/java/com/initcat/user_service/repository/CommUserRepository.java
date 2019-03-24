package com.initcat.user_service.repository;

import com.initcat.user_service.model.db.CommUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.repository
 * @company initcat
 * @date 2018/11/26
 */
public interface CommUserRepository extends JpaRepository<CommUser, Long> {

    CommUser findByPhone(String userPhone);

}
