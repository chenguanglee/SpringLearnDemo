package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/20 21:22
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {

            res = height[left] > height[right] ? Math.max(res, (right - left) * height[right--]) : Math.max(res, (right - left) * height[left++]);
        }
        return res;
    }

    @Test
    public void test() {
        int i = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
