package com.initcat.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 *
 * @author libo
 * @package com.initcat.user_service.controller
 * @company xmiles
 * @date 2019/6/12
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/testOOM")
    public void testOOM() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>testOOM start");
        String name = "hello";
        for (int i = 0; i < 1000000000; i++) {
            name += name;
        }
        System.out.println(name);
    }

    @GetMapping("/testJstack")
    public void testJstack() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>testJstack start");
        int i = 0;
        while (true) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>testJstack: " + i++);
        }
    }

}
