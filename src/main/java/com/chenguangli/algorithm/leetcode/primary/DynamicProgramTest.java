package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

/**
 * 动态规划问题
 *
 * @author chenguangli
 * @date 2020/4/23 21:19
 */
public class DynamicProgramTest {

    /**
     * 体积
     */
    int[] w = {2, 3, 4, 5};
    /**
     * 价值
     */
    int[] v = {3, 4, 5, 6};

    /**
     * 背包问题, n为给的体积
     *
     * @param n
     */
    public int packageProblem(int n) {
        int x = w.length + 1;
        int y = n + 1;
        int[][] res = new int[x][y];
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (w[i - 1] > j) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return res[x - 1][y - 1];
    }

    @Test
    public void testPackage() {
        int i = packageProblem(8);
        System.out.println(i);
    }
}
