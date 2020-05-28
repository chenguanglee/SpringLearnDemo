package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/27 23:40
 */
public class 丑数 {

    /**
     * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 说明:  
     * <p>
     * 1 是丑数。
     * n 不超过1690。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int d = dp[a] * 2;
            int e = dp[b] * 3;
            int f = dp[c] * 5;
            dp[i] = Math.min(d, Math.min(e, f));
            if (dp[i] == d) a++;
            if (dp[i] == e) b++;
            if (dp[i] == f) c++;
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        int i = nthUglyNumber(10);
        System.out.println(i);
    }
}
