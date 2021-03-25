package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/28 23:20
 */
public class 把数字翻译成字符串_46 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
     * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
     * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = s.charAt(i - 1);
            int f = (d - '0') * 10 + (c - '0');
            if (f >= 10 && f <= 25) {
                dp[i + 1] = dp[i - 1] + dp[i];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        System.out.println(translateNum(12258));
    }
}
