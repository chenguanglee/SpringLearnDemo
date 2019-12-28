package com.chenguangli.spring.dubbo;

import com.dubbo.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DubboConfig.class)
public class ConsumerTest {

    @Autowired
    private HelloService helloService;


    @Test
    public void test1() {

        System.out.println(helloService.sayHello("chenhu"));
    }
}
