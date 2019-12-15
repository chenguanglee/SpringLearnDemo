package com.chenguangli.spring.soudsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration //表明这个类是一个配置类, 这样在类下可以使用@Bean 注解配置bean
//@ComponentScan //(下面定义了@Bean就会冲突) 自动化配置
@Import(CDConfig.class) //引入其他javaConfig
//@ImportResource("classpath:spring.xml") //导入xml中的bean配置
public class CDPlayerConfig {

    @Autowired
    private Environment env;

    //java显示配置
    @Bean(name = "sgtPeppers") //默认名称为'sgtPeppers'
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean(name = "cdPlayer")
    //@Profile("dev")//配置当前bean的运行环境
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }
}

