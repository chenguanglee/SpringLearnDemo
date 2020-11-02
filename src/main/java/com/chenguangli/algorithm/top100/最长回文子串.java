package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/12 20:54
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int k = s.length() - 1;
            while (j < k) {
                if (s.charAt(j) == s.charAt(k)) {
                    String a = s.substring(j, k + 1);
                    if (isReStr(a)) {
                        res = res.length() < a.length() ? a : res;
                    }
                }
                k--;
            }
        }
        return res;
    }

    public boolean isReStr(String s) {
        int j = 0;
        int k = s.length() - 1;
        while (j < k) {
            if (s.charAt(j) != s.charAt(k)) {
                return false;
            }
            j++;
            k--;
        }
        return true;
    }


    public String longestPalindrome0(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int k = 0; k < r; k++) {
                if (s.charAt(k) == s.charAt(r) && (r - k <= 2 || dp[k + 1][r - 1])) {
                    dp[k][r] = true;
                    if (r - k + 1 > maxLen) {
                        maxLen = r - k + 1;
                        maxStart = k;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

    @Test
    public void test() {
        String babad = longestPalindrome0("babad");
        System.out.println(babad);
    }

}
