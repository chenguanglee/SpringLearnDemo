package com.chenguangli.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2019/4/21 21:27
 */
public class LambdaExample {

    @Test
    public void test1() {
        List<String> list = buildList();

        list.forEach((tmp) -> System.out.println(tmp + ","));

        list.forEach(System.out::println);
        

    }


    public List<String> buildList() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("asd");
        return list;
    }
}
