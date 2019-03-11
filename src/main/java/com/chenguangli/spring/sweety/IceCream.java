package com.chenguangli.spring.sweety;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("cold")
@Cold
public class IceCream implements Dessert {

    @Override
    public void printDetailSweety() {
        System.out.println("i am ice cream!!!");
    }
}
