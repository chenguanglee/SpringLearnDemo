package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/5 22:19
 */
public class 礼物的最大价值_47 {

    public int maxValue(int[][] grid) {
        int j = grid.length;
        int k = grid[0].length;
        for (int i = 0; i < j; i++) {
            for (int q = 0; q < k; q++) {
                if (i == 0 && q == 0) {

                } else if (i == 0) {
                    grid[i][q] += grid[i][q - 1];
                } else if (q == 0) {
                    grid[i][q] += grid[i - 1][q];
                } else {
                    grid[i][q] += Math.max(grid[i - 1][q], grid[i][q - 1]);
                }
            }
        }
        return grid[j - 1][k - 1];
    }
}
