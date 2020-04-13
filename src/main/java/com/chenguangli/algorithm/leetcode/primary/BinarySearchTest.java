package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

/**
 * 二分查找
 *
 * @author chenguangli
 * @date 2020/4/6 11:25
 */
public class BinarySearchTest {

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        int middle = 0;
        while (left < right) {
            middle = left + (right - left) / 2;
            long square = (long) middle * middle;
            if (square == x) {
                return middle;
            } else if (square > x) {
                right = middle - 1;
                long sum = (long)right * right;
                if (sum == x) {
                    return right;
                }
                if (sum < x) {
                    return right;
                }
            } else {
                left = middle + 1;
                long sum = (long)left * left;
                if (sum == x) {
                    return left;
                }
                if (sum >= x) {
                    return left - 1;
                }
            }
        }
        return middle;
    }


    @Test
    public void testBS() {
        int i2 = mySqrt(0);
        int i6 = mySqrt(2);
        int i = mySqrt(5);
        int k = mySqrt(7);
        int i1 = mySqrt(10);
        int i3 = mySqrt(9);
        int i4 = mySqrt(36);
        int i5 = mySqrt(2147395599);
        System.out.println(i);
    }
}
