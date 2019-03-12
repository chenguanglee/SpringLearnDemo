package com.chenguangli.spring.sweety;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // 每次注入或者通过spring应用上下文获取的时候, 都会创建一个新的bean实例
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //整个应用, 只创建bean的一个实例
public class Cake implements Dessert {

    @Override
    public void printDetailSweety() {
        System.out.println("i am cake!!");
    }
}
