package com.chenguangli.spring.sweety;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cake implements Dessert {

    @Override
    public void printDetailSweety() {
        System.out.println("i am cake!!");
    }
}
