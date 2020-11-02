package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/7 21:36
 */
public class 最短无序连续子数组 {

    public int findUnsortedSubarray(int[] nums) {
        //input check
        if (nums == null || nums.length == 0)
            return 0;
        //
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int rightBorder = -1, leftBorder = nums.length;
        //从左往右遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max)
                max = nums[i];
            else
                rightBorder = i;
        }
        //从右往左遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min)
                min = nums[i];
            else
                leftBorder = i;
        }
        return rightBorder > leftBorder ? rightBorder - leftBorder + 1 : 0;
    }

    @Test
    public void test() {
        int unsortedSubarray = findUnsortedSubarray(new int[]{1, 2, 3, 4});
        System.out.println(unsortedSubarray);
    }
}
