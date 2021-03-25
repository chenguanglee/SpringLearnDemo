package com.chenguangli.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2021/1/23 16:10
 */
public class PersonImpl implements Person {

    @Override
    public void say() {
        this.sayHello();
        List<Integer> list = new ArrayList<>();
        list.remove(Integer.valueOf(1));
        list.remove(1);
    }
}