package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author chenguangli
 * @date 2020/5/29 22:39
 */
public class 剪绳子2 {


    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= n <= 1000
     *
     * @param n
     * @return
     */
    public long cuttingRope(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int k = 1; k < i; k++) {
                dp[i] = Math.max(Math.max(BigDecimal.valueOf(dp[i - k]).multiply(BigDecimal.valueOf(k)).remainder(BigDecimal.valueOf(1000000007L)).longValue(), ((i - k) * k)), dp[i]);
            }
        }
        return dp[n];
        //return dp[n];

    }

    @Test
    public void test() {
        long l = cuttingRope(120);
        System.out.println(l);
        long i = cuttingRope1(120);
        System.out.println(i);
    }

    public int cuttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = 1000000007;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }

}
