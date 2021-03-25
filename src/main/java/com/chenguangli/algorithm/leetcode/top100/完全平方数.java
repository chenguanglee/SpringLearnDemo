package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/3 23:06
 */
public class 完全平方数 {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     * <p>
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //dp[1] = 1
        //dp[2] = 2;
        //dp[3] = 3;
        //dp[4] = 1;
        //dp[5] = 2
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                int i1 = i - j * j;
                int i2 = dp[i1];
                dp[i] = Math.min(dp[i], i2 + 1);
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        int i = numSquares(13);
        System.out.println(i);
    }
}
