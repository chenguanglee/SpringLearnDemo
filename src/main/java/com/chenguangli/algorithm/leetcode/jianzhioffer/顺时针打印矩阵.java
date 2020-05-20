package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/20 21:35
 */
public class 顺时针打印矩阵 {

    /**
     * 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int a = 0, b = matrix.length - 1, c = 0, d = matrix[0].length - 1, x = 0;
        while (true) {
            for (int i = c; i <= d; i++) {
                res[x++] = matrix[a][i];
            }
            if (++a > b) {
                break;
            }
            for (int i = a; i <= b; i++) {
                res[x++] = matrix[i][d];
            }
            if (--d < c) {
                break;
            }
            for (int i = d; i >= c; i--) {
                res[x++] = matrix[b][i];
            }
            if (--b < a) {
                break;
            }
            for (int i = b; i >= a; i--) {
                res[x++] = matrix[i][c];
            }
            if (++c > d) {
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = spiralOrder(matrix);
        System.out.println(ints);
    }
}
