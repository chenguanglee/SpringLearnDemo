package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/6/29 23:34
 */
public class 不用加减乘除做加法 {

    public int add(int a, int b) {
        while (b != 0) {
            int c = a & b;
            int d = a ^ b;
            a = d;
            b = c << 1;
        }
        return a;
    }

    @Test
    public void test() {
        System.out.println(add(0, 10));
    }
}
