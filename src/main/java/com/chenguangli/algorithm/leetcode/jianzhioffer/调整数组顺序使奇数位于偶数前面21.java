package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/29 21:51
 */
public class 调整数组顺序使奇数位于偶数前面21 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10000
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0, k = nums.length - 1;
        while (i < k) {
            int left = nums[i];
            int right = nums[k];
            if (left % 2 == 1) {
                i++;
                continue;
            }
            if (right % 2 == 0) {
                k--;
                continue;
            }
            nums[i] = nums[k];
            nums[k] = left;
        }

        return nums;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,5};
        int[] exchange = exchange(nums);
        System.out.println();
    }
}
