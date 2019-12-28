package com.chenguangli.spring.dubbo;

import com.dubbo.protocol.framework.ProxyFactory;
import com.dubbo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenguangli
 * @date 2019/12/27 21:58
 */
@Configuration
@ComponentScan
public class DubboConfig {

    @Bean
    public HelloService getHelloService() {
        return ProxyFactory.getProxy(HelloService.class);
    }

}
