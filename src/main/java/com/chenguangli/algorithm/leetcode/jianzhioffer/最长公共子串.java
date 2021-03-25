package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2021/1/23 15:43
 */
public class 最长公共子串 {

    /**
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
     *
     * @param str1
     * @param str2
     * @return
     */
    public String LCS(String str1, String str2) {
        int start = 0, end = 1;
        String res = null;

        while (end <= str1.length()) {
            String substring = str1.substring(start, end);
            if (str2.contains(substring)) {
                if (res == null || res.length() < substring.length()) {
                    res = substring;
                }
                end++;
            } else {
                start++;
                end = start + 1;
            }
        }
        if (res == null) {
            res = "-1";
        }
        return res;
    }

    @Test
    public void test() {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";

        String lcs = LCS(str1, str2);
        System.out.println(lcs);
    }
}
