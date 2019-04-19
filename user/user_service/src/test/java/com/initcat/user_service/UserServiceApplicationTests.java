package com.initcat.user_service;

import com.initcat.user_common.dto.CoinTransResultDTO;
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
		System.out.println(">>>>>>>>coinTest, 开始");
		Thread t1 = getThread(123L,1L, 100, 111, "t1");
		Thread t2 = getThread(123L,2L, 200, 222, "t2");
		t1.start();
		t2.start();
		Thread.sleep(100000L);
		System.out.println(">>>>>>>>coinTest, 结束");
	}

    private Thread getThread(long userId, long businessId, int transCode, int rechargeCoin, String tName) {
        return new Thread(() -> {
            try {
                CoinRechargeReq coinRechargeReq2 = new CoinRechargeReq();
                coinRechargeReq2.setUserId(userId);
                coinRechargeReq2.setBusinessId(businessId);
                coinRechargeReq2.setTransCode(transCode);
                coinRechargeReq2.setRechargeCoin(rechargeCoin);
                coinRechargeReq2.setTransMsg(">>>>>>>>" + tName + ", Test");
                System.out.println(">>>>>>>>" + tName+", 开始");
                CoinTransResultDTO recharge2 = coinService.recharge(coinRechargeReq2);
                System.out.println(">>>>>>>>" + tName + ":" + recharge2.getTransResult().getMsg());
                System.out.println(">>>>>>>>" + tName+", 结束");
            } catch (Throwable e) {
                System.out.println(">>>>>>>>" + tName + ",Exception");
                e.printStackTrace();
            }
        }, tName);
    }
}
