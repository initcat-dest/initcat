package com.initcat.user_service;

import com.initcat.user_service.service.WalletService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WalletService walletService;

	@Test
	public void WalletServiceTest(){
		walletService.recharge(3L, 1001, "测试", 100, 9999L);
	}
}
