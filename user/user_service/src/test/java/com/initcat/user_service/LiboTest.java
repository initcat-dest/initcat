package com.initcat.user_service;

import com.initcat.user_service.util.RedisUtils;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_service
 * @company xmiles
 * @date 2019/3/24
 */
public class LiboTest {

	public static void main(String[] args) {
		System.out.println(RedisUtils.set("test", "1"));
		System.out.println(RedisUtils.get("test"));
		System.out.println("end");
	}
}
