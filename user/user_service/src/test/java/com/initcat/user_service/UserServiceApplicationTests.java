package com.initcat.user_service;

import com.initcat.user_common.model.dto.CoinTransResultDTO;
import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.service.CoinService;
import com.initcat.user_common.service.WalletService;
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

	@Autowired
	CoinService coinService;

	@Test
	public void WalletServiceTest(){
		// walletService.recharge(3L, 1001, "测试", 100, 9999L);
	}

	@Test
	public void coinTest() {
		System.out.println("开始");
		Thread t1 = new Thread(() -> {
			CoinRechargeReq coinRechargeReq = new CoinRechargeReq();
			coinRechargeReq.setUserId(123L);
			coinRechargeReq.setBusinessId(1L);
			coinRechargeReq.setTransCode(100);
			coinRechargeReq.setRechargeCoin(111);
			CoinTransResultDTO recharge = coinService.recharge(coinRechargeReq);
			System.out.println("t1:"+recharge.getTransResult().getMsg());
		}, "t1");
		Thread t2 = new Thread(() -> {
			CoinRechargeReq coinRechargeReq1 = new CoinRechargeReq();
			coinRechargeReq1.setUserId(123L);
			coinRechargeReq1.setBusinessId(2L);
			coinRechargeReq1.setTransCode(200);
			coinRechargeReq1.setRechargeCoin(222);
			CoinTransResultDTO recharge2 = coinService.recharge(coinRechargeReq1);
			System.out.println("t2:"+recharge2.getTransResult().getMsg());
		}, "t2");
		t1.start();
		t2.start();
		System.out.println("结束");
	}
}
