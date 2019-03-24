package com.initcat.user_service.dao;

import com.initcat.user_service.model.db.CommUser;

public interface UserDao {

	CommUser findByPhone(String userPhone);

}
