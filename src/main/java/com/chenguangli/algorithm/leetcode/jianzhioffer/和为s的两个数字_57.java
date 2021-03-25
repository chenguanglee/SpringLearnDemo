package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/7 21:25
 */
public class 和为s的两个数字_57 {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s > target) {
                j--;
            } else if (s < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return null;
    }
}
