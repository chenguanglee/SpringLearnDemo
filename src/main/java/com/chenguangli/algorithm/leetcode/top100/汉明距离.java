package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/10 21:29
 */
public class 汉明距离 {

    public int hammingDistance(int x, int y) {
        int b = x ^ y;
        int a = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int k = a & b;
            if (k != 0) {
                count++;
            }
            a <<= 1;
        }
        return count;
    }

    @Test
    public void test() {
        int i = hammingDistance(0, 10);
        System.out.println(i);
    }
}
