package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/29 16:32
 */
public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int a = 1;
        int b = nums.length;
        int res = -1;
        while (a <= b) {
            int mid = (a + b) >> 1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                b = mid - 1;
                res = mid;
            } else {
                a = mid + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int duplicate = findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(duplicate);
    }
}
