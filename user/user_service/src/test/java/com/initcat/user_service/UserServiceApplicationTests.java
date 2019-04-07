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
	public void coinTest() throws InterruptedException {
		System.out.println("开始");
		Thread t1 = new Thread(() -> {
			try {
				CoinRechargeReq coinRechargeReq1 = new CoinRechargeReq();
				coinRechargeReq1.setUserId(123L);
				coinRechargeReq1.setBusinessId(1L);
				coinRechargeReq1.setTransCode(100);
				coinRechargeReq1.setRechargeCoin(111);
                coinRechargeReq1.setTransMsg("t1Test");

                System.out.println("t1开始");
                CoinTransResultDTO recharge = coinService.recharge(coinRechargeReq1);
				System.out.println("t1:"+recharge.getTransResult().getMsg());
				System.out.println("t1结束");
			} catch (Throwable e) {
				System.out.println("t1Exception");
				e.printStackTrace();
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
            try {
                CoinRechargeReq coinRechargeReq2 = new CoinRechargeReq();
                coinRechargeReq2.setUserId(123L);
                coinRechargeReq2.setBusinessId(2L);
                coinRechargeReq2.setTransCode(200);
                coinRechargeReq2.setRechargeCoin(222);
                coinRechargeReq2.setTransMsg("t2Test");
                System.out.println("t2开始");
                CoinTransResultDTO recharge2 = coinService.recharge(coinRechargeReq2);
                System.out.println("t2:"+recharge2.getTransResult().getMsg());
				System.out.println("t2结束");
			} catch (Throwable e) {
				System.out.println("t2Exception");
				e.printStackTrace();
			}
		}, "t2");
		t1.start();
		t2.start();
		Thread.sleep(100000L);
		System.out.println("结束");
	}
}
