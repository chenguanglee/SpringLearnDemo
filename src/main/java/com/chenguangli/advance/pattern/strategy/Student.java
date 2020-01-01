package com.chenguangli.advance.pattern.strategy;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenguangli
 * @date 2019/6/26 23:11
 */
@Component
public class Student {

    private List<DemoInterface> demoInterface;



    public Student(List<DemoInterface> list) {
        this.demoInterface = list;
    }

    public void setDemoInterface(List<DemoInterface> demoInterface) {
        this.demoInterface = demoInterface;
    }

    public List<DemoInterface> getDemoInterface() {
        return demoInterface;
    }
}
