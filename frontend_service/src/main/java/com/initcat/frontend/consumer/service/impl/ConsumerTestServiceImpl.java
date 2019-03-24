package com.initcat.frontend.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.initcat.frontend.consumer.service.ConsumerTestService;
import com.initcat.user_common.service.UserService;
import org.springframework.stereotype.Service;

/**
 * class description
 *
 * @author libo
 * @package com.frontend.consumer.service.impl
 * @company xmiles
 * @date 2019/3/12
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ConsumerTestServiceImpl implements ConsumerTestService {

	@Reference
	UserService userService;

	@Override
	public String consumerTest() {
		userService.logOut("test");
		return null;
	}
}
