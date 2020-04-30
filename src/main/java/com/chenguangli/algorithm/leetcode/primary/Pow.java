package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/4/30 22:39
 */
public class Pow {

    /**
     * 数值的整数次方
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     * <p>
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     * <p>
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n==0){
            return 0;
        }
        if (n == 1){
            return x;
        }
        long k = n;
        if (n < 0) {
            x = 1 / x;
            k = -k;
        }
        double res = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                res *= x;
            }
            x *= x;
            k >>= 1;
        }
        return res;
    }

    @Test
    public void testPow() {
        double v = myPow(2.1, 3);
        System.out.println(v);
    }
}
