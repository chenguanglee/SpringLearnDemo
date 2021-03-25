package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2020/12/22 21:25
 */
public class 数组中重复的数字3 {


    /**
     * 找出数组中重复的数字。
     * <p>
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *  
     * <p>
     * 限制：
     * <p>
     * 2 <= n <= 100000
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        return -1;
    }

    /**
     * 两次for循环
     * 时间复杂度O(n2)
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            throw new RuntimeException("未找到");
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int solution2(int[] nums) {
        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i]++;
            if (temp[i] > 1) {
                return i;
            }
        }
        return -1;
    }
}
