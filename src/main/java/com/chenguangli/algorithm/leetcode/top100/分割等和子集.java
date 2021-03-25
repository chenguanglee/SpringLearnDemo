package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/11 21:37
 */
public class 分割等和子集 {

    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * 注意:
     * <p>
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     * <p>
     * 输入: [1, 5, 11, 5]
     * <p>
     * 输出: true
     * <p>
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *  
     * <p>
     * 示例 2:
     * <p>
     * 输入: [1, 2, 3, 5]
     * <p>
     * 输出: false
     * <p>
     * 解释: 数组不能分割成两个元素和相等的子集.
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j] || j - nums[i] > 0 && dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
}
