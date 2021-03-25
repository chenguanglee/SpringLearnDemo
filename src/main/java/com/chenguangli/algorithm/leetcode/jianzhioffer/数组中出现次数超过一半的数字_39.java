package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2021/1/6 21:55
 */
public class 数组中出现次数超过一半的数字_39 {

    public int majorityElement(int[] nums) {
        int a = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                a = nums[i];
                count++;
            } else {
                if (a == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return a;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }
}
