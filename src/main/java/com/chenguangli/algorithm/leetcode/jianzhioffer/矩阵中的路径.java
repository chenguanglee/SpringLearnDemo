package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/24 17:00
 */
public class 矩阵中的路径 {


    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * <p>
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * <p>
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     * 提示：
     * <p>
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int x = board.length;
        int y = board[0].length;
        char[] wordC = word.toCharArray();
        for (int i = 0; i < x; i++) {
            for (int k = 0; k < y; k++) {
                if (find(board, i, k, wordC, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int m, int n, char[] wordC, int k) {
        //越界处理
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length) {
            return false;
        }
        if (board[m][n] != wordC[k]) {
            return false;
        }
        if (k == wordC.length - 1) {
            return true;
        }
        char temp = board[m][n];
        board[m][n] = ' ';
        boolean b = find(board, m + 1, n, wordC, k + 1) || find(board, m - 1, n, wordC, k + 1) || find(board, m, n + 1, wordC, k + 1) || find(board, m, n - 1, wordC, k + 1);
        board[m][n] = temp;
        return b;
    }

    @Test
    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean abcced = exist(board, "ABCCED");
        System.out.println(abcced);

        char[][] board1 = {{'a', 'a'}};
        boolean abcd = exist(board1, "aa");
        System.out.println(abcd);
    }
}
