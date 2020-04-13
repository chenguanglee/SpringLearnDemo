package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/4/10 20:19
 */
public class BinaryTest {

    /**
     * 二进制中1的个数
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * <p>
     * 示例 1：
     * <p>
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     * <p>
     * 说明：
     * <p>
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] res = new int[max-1];
        for (int i = 1; i < max; i++) {
            res[i-1] = i;
        }
        return res;
    }



    @Test
    public void test1() {
        int i = hammingWeight(-0);
        System.out.println(i);
        int pow = (int) Math.pow(10, 2);
        System.out.println(pow);
        int[] ints = printNumbers(2);
        System.out.println();
    }
}
