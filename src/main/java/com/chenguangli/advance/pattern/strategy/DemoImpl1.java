package com.chenguangli.advance.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author chenguangli
 * @date 2019/6/22 22:51
 */
@Component
public class DemoImpl1 implements DemoInterface {

    private boolean a;

    private byte b;

    @Override
    public String getStr(String str) {
        //System.out.println("DemoImpl1");
        return str;
    }
}
