package com.chenguangli.spring.sweety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoveDessert {

    private Dessert dessert;

    //@Autowired
    public LoveDessert(Dessert dessert) {
        System.out.println("through constructor");
        this.dessert = dessert;
    }

    //@Autowired
   // @Qualifier("cold")
    //@Cold
    private void setDessert(Dessert dessert) {
        System.out.println("through setter");
        this.dessert = dessert;
    }

    public void taste() {
        dessert.printDetailSweety();
    }
}
