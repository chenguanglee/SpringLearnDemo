package com.chenguangli.leetcode.primary;

/**
 * 背包问题
 *
 * @author chenguangli
 * @date 2019/9/9 23:12
 */
public class PackageProblemTest {

    public void packagePro() {
        int[] value = {3, 4, 5, 6};
        int[] w = {2, 3, 4, 5};
        int boxSize = 8;
        int[][] p = new int[5][9];

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 9; j++) {
                if (w[i] <= j) {
                    p[i][j] = Math.max(p[i - 1][j], p[i - 1][j - w[i]] + value[i]);
                } else {
                    p[i][j] = p[i - 1][j];
                }
            }
        }
    }
}
