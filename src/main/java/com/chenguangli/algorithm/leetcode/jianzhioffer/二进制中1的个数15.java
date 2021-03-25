package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/31 21:00
 */
public class 二进制中1的个数15 {

    /**
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     * <p>
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * 示例 3：
     * <p>
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *  
     * <p>
     * 提示：
     * <p>
     * 输入必须是长度为 32 的 二进制串 。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int a = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int k = n & a;
            if (k != 0) {
                count++;
            }
            a <<= 1;
        }
        System.out.println(a);
        return count;
    }

    @Test
    public void test() {
        int a = -1;
        String s = Integer.toBinaryString(a);
        int i = hammingWeight(a);
        System.out.println(i);
    }
}
