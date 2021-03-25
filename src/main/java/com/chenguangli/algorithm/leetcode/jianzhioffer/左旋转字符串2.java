package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/27 14:46
 */
public class 左旋转字符串2 {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     *  
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
     * <p>
     * 限制：
     * <p>
     * 1 <= k < s.length <= 10000
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length()+ n; i++) {
            sb.append(s.charAt(i % (s.length())));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
