package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

import java.util.*;

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
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
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


    @Test
    public void testFind() {
        char[][] board1 = {{'a', 'a'}};
        boolean abcd = exist(board1, "aa");
        System.out.println(abcd);
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
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }


    /**
     * 比较版本号
     * 比较两个版本号 version1 和 version2。
     * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
     * <p>
     * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
     * <p>
     *  . 字符不代表小数点，而是用于分隔数字序列。
     * <p>
     * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
     * <p>
     * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int k = v1.length > v2.length ? v1.length : v2.length;
        for (int i = 0; i < k; i++) {
            if (i >= v1.length) {
                int b = Integer.parseInt(v2[i]);
                if (b != 0) {
                    return -1;
                }
            } else if (i >= v2.length) {
                int a = Integer.parseInt(v1[i]);
                if (a != 0) {
                    return 1;
                }
            } else {
                int a = Integer.parseInt(v1[i]);
                int b = Integer.parseInt(v2[i]);
                if (a > b) {
                    return 1;
                }
                if (a < b) {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * I. 翻转单词顺序
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     * <p>
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     * <p>
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                sb.append(s1[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }


    /**
     * 字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * <p>
     *  
     * <p>
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     * @param s
     * @return
     */

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        per(s, "", visited, set);
        return set.toArray(new String[s.length()]);
    }

    public void per(String s, String k, boolean[] visited, Set<String> set) {
        if (k.length() == s.length()) {
            set.add(k);
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            char c = s.charAt(i);
            visited[i] = true;
            per(s, k + String.valueOf(c), visited, set);
            visited[i] = false;
        }
    }

    @Test
    public void testPermutation() {
        String[] abbs = permutation("abb");
        System.out.println(abbs);
    }

    @Test
    public void testReverseWords() {
        String a = "the sky is blue";
        System.out.println(reverseWords(a));
        String b = "  hello world!  ";
        System.out.println(reverseWords(b));
        String c = "a good  example";
        System.out.println(reverseWords(c));
    }

    @Test
    public void testCompareVersion() {
        String version1 = "1.0.1", version2 = "1";
        int i = compareVersion(version1, version2);
        System.out.println(i);

        version1 = "1";
        version2 = "1.0.1";
        i = compareVersion(version1, version2);
        System.out.println(i);

        version1 = "0.1";
        version2 = "1.1";
        i = compareVersion(version1, version2);
        System.out.println(i);

        version1 = "7.5.2.4";
        version2 = "7.5.3";
        i = compareVersion(version1, version2);
        System.out.println(i);

        version1 = "1.01";
        version2 = "1.001";
        i = compareVersion(version1, version2);
        System.out.println(i);

        version1 = "1.0";
        version2 = "1.0.0";
        i = compareVersion(version1, version2);
        System.out.println(i);
    }

    @Test
    public void testFirstUniqChar() {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }



}
