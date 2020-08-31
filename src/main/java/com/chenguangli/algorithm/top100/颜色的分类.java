package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/29 16:00
 */
public class 颜色的分类 {
    public void sortColors(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        int c = 0;
        while (c <= q) {
            if (nums[c] == 0) {
                int num = nums[p];
                nums[p++] = nums[c];
                nums[c++] = num;
            } else if (nums[c] == 2) {
                int num = nums[q];
                nums[q--] = nums[c];
                nums[c] = num;
            } else {
                c++;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{ 2,0,1};
        sortColors(nums);
        System.out.println();
    }
}
