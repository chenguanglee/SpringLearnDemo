package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

public class StringTest {


    @Test
    public void testIntern() {
        String a = "123 23   3";
        replaceSpace("We are happy.");
        String[] s1 = a.split(" ");
        String s = "123";
        s.intern();
    }

    /**
     * 替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }


    /**
     * 矩阵中的路径
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
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (find(board, words, x, y, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, char[] words, int x, int y, int k) {
        if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
            return false;
        }
        if (board[x][y] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = ' ';
        boolean res = find(board, words, x - 1, y, k + 1) ||
                find(board, words, x + 1, y, k + 1) ||
                find(board, words, x, y - 1, k + 1) ||
                find(board, words, x, y + 1, k + 1);
        board[x][y] = tmp;
        return res;
    }

    /**
     * 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
     * <p>
     * 示例:
     * <p>
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < chars.length; j++) {
                if (j == i) {
                    continue;
                }
                if (chars[i] == chars[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return chars[i];
            }
        }
        return ' ';
    }

    /**
     * 左旋转字符串
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 示例 2：
     * <p>
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i%s.length()));
        }
        return sb.toString();
    }

    @Test
    public void testFirstUniqChar() {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }


    @Test
    public void testFind() {
        char[][] chars = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};

        boolean asad = exist(chars, "AAB");
        System.out.println(asad);
    }
}
