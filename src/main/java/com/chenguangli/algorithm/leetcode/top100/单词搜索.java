package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/11/28 23:42
 */
public class 单词搜索 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *  
     * <p>
     * 提示：
     * <p>
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if (find(board, i, i1, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int x, int y, String word, int index) {
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (word.length()-1 == index) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '-';
        boolean b = find(board, x + 1, y, word, index + 1) || find(board, x, y + 1, word, index + 1) || find(board, x - 1, y, word, index + 1) || find(board, x, y - 1, word, index + 1);
        board[x][y] = temp;
        return b;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean abcced = exist(board, "FCED");
        System.out.println(abcced);
    }
}
