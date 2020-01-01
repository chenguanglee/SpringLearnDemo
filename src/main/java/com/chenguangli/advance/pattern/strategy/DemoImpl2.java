package com.chenguangli.advance.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author chenguangli
 * @date 2019/6/22 22:51
 */
@Component
public class DemoImpl2 implements DemoInterface {


    private String a;

    private Integer b;

    @Override
    public String getStr(String str) {
        //System.out.println("DemoImpl2");
        return str;
    }
}
