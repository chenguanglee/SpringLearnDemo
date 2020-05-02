package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/2 22:52
 */
public class DP {


    /**
     * 礼物的最大价值
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (i == 0 && k == 0) {

                } else if (i == 0) {
                    grid[i][k] = grid[i][k - 1] + grid[i][k];
                } else if (k == 0) {
                    grid[i][k] = grid[i - 1][k] + grid[i][k];
                } else {
                    grid[i][k] = Math.max(grid[i - 1][k], grid[i][k - 1]) + grid[i][k];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i < s.length(); i++) {
            String k = s.substring(i - 2, i);
            int c;
            if (k.compareTo("10") >= 0 && k.compareTo("25") <= 0) {
                c = a + b;
            } else {
                c = b;
            }
            a = b;
            b = c;
        }
        return b;
    }

    @Test
    public void testTranslateNum() {
        System.out.println(translateNum(12258));
    }

    @Test
    public void testMaxValue() {
        int[][] g = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int i = maxValue(g);
        System.out.println(i);
    }
}
