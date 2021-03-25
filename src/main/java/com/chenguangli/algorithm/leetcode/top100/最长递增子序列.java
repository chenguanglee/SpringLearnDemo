package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenguangli
 * @date 2020/12/16 22:34
 */
public class 最长递增子序列 {


    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     *  
     * <p>
     * 进阶：
     * <p>
     * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
     * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
