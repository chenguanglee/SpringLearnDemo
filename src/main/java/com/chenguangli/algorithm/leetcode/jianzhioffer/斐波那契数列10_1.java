package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/28 22:55
 */
public class 斐波那契数列10_1 {

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：n = 5
     * 输出：5
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= n <= 100
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b % 1000000007;
            b = c;
        }
        return b%1000000007;
    }

    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    @Test
    public void test() {
        int i = fib1(6);
        System.out.println(i);

        int fib = fib(6);
        System.out.println(fib);
    }
}
