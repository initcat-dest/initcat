package com.initcat.user_service;

import com.initcat.user_common.model.req.CoinRechargeReq;
import com.initcat.user_common.service.CoinService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 金币测试
 *
 * @author libo
 * @package com.initcat.user_service
 * @company xmiles
 * @date 2019/4/7
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinTest {

    @Autowired
    CoinService coinService;

    /**
     * 并发量
     */
    private int THREAD_NUM = 20;
    /**
     * 总访问量
     */
    private int CLIENT_NUM = 20;

    private static int index = 0;

    @Test
    public void coinRechargeTest() {

        // 建立ExecutorService线程池，threadNum个线程可以同时访问
        ExecutorService exec = Executors.newFixedThreadPool(THREAD_NUM);
        // 模拟clientNum个客户端访问
        final CountDownLatch doneSignal = new CountDownLatch(CLIENT_NUM);

        for (int i = 0; i < CLIENT_NUM; i++) {
            Runnable run = () -> {
                try {
                    int index = getIndex();
                    System.out.println(System.currentTimeMillis());
                    CoinRechargeReq coinRechargeReq2 = new CoinRechargeReq();
                    coinRechargeReq2.setUserId(3788L);
                    coinRechargeReq2.setBusinessId(1L);
                    coinRechargeReq2.setTransCode(index);
                    coinRechargeReq2.setRechargeCoin(index);
                    coinRechargeReq2.setTransMsg(index + "Test");
                    coinService.recharge(coinRechargeReq2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 每调用一次countDown()方法，计数器减1
                doneSignal.countDown();
            };
            exec.execute(run);
        }

        try {
            // 计数器大于0时，await()方法会阻塞程序继续执行
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getIndex() {
        return ++index;
    }
}
