package com.chenguangli.algorithm.leetcode.middle.recall;

import org.junit.Test;

/**
 * n皇后问题 (回溯算法)
 *
 * @author chenguangli
 * @date 2020/1/2 21:49
 */
public class Queen {

    /**
     * 表示皇后摆放的位置
     * 如 cols[0] = 2 ,表示第一行的皇后摆放在第三个位置
     * 4皇后问题
     * 0 1 2 3
     * 0 0 0 1 0  cols[0] = 2
     * 1 0 0 0 1  cols[1] = 4
     * 2 0 0 0 0
     * 3 0 0 0 0
     */
    private int[] cols;

    private int ways;

    @Test
    public void testQueen() {
        placeQueen(4);
    }

    public void placeQueen(int n) {
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后的摆法有" + ways + "种");
    }

    public void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isUseful(row, col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    public boolean isUseful(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;

            //第一种 (6/5 == 1)  wrong
//            if ((row - i) / (col - cols[i]) == 1) return false;
//            if ((row - i) / (col - cols[i]) == -1) return false;

            //第二种
            if ((row - i) == Math.abs(col - cols[i])) return false;
        }
        return true;
    }

    public void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("============");
    }

}
