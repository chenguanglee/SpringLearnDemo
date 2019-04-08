package com.chenguangli.spring.concert;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance {

    @Override
    public void perform() {
        System.out.println("PerformanceImpl perform()");
    }
}
