package com.initcat.user_service.dao.impl;

import com.initcat.user_service.dao.UserDao;
import com.initcat.user_service.model.db.CommUser;
import com.initcat.user_service.repository.CommUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_service.dao.impl
 * @company xmiles
 * @date 2019/3/18
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	CommUserRepository commUserRepository;

	@Override
	public CommUser findByPhone(String userPhone) {
		return commUserRepository.findByPhone(userPhone);
	}

}
