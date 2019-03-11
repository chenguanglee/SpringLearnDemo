package com.chenguangli.spring.soudsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //表明这个类是一个配置类
//@ComponentScan //(下面定义了@Bean就会冲突) 自动化配置
@Import(CDConfig.class) //引入其他javaConfig
public class CDPlayerConfig {

    //java显示配置
    @Bean(name = "sgtPeppers") //默认名称为'sgtPeppers'
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean(name = "cdPlayer")
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }
}

