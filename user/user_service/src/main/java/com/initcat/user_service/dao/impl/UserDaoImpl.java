package com.initcat.user_service.dao.impl;

import com.alicp.jetcache.anno.Cached;
import com.initcat.user_service.dao.UserDao;
import com.initcat.user_service.model.db.CommUser;
import com.initcat.user_service.repository.CommUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.initcat.user_service.constant.redis.UserRedisConstant.USER_INFO;

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
	@Cached(name = USER_INFO, key = "#userPhone", expire = 200)
	public CommUser findByPhone(String userPhone) {
		return commUserRepository.findByPhone(userPhone);
	}

}
