package com.chenguangli.spring.dubbo;

import com.dubbo.service.HelloService;

/**
 * @author chenguangli
 * @date 2019/12/27 23:11
 */
public class HelloServiceProxy implements HelloService {

    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {

      this.helloService = helloService;
    }

    @Override
    public String sayHello(String s) {
        System.out.println("execute before");
        String s1 = helloService.sayHello(s);
        System.out.println("execute after!");
        return s1;
    }
}
