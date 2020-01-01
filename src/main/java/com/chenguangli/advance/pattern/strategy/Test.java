package com.chenguangli.advance.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenguangli
 * @date 2019/6/22 22:52
 */
public class Test {


    @Autowired
    private Student student;

    public static void main(String[] args) {


        Test test = new Test();

        int type = 1;


        boolean a = false;
        byte b = 1;

        DemoImpl1 demoImpl1 = new DemoImpl1();

        DemoImpl2 demoImpl2 = new DemoImpl2();

        String c = "123";
        Integer d = 12;


        DemoInterface demoInterface = get(type, demoImpl1);


    }


    public static DemoInterface get(int type, Object o) {
        if (type == 1) {
            return new DemoImpl1();
        } else {
            return new DemoImpl2();
        }

    }
}
