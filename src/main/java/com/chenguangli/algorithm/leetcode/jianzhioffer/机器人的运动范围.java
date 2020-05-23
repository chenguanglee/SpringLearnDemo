package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/23 18:55
 */
public class 机器人的运动范围 {


    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
     * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * 提示：
     * <p>
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    private int x;
    private int y;
    private int range;
    private boolean[][] isVisit;

    public int movingCount(int m, int n, int k) {
        x = m - 1;
        y = n - 1;
        range = k;
        isVisit = new boolean[m][n];
        return move(0, 0, 0, 0);
    }

    public int move(int i, int j, int is, int js) {
        if (i > x || j > y || (is + js) > range || isVisit[i][j]) return 0;
        isVisit[i][j] = true;
        return 1 + move(i, j + 1, is, ((j + 1) / 10) + ((j + 1) % 10)) + move(i + 1, j, ((i + 1) / 10) + ((i + 1) % 10), js);
    }

    @Test
    public void test() {
        int i = movingCount(2, 3, 1);
        System.out.println(i);
    }
}
