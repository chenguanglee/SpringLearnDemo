package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/3 21:33
 */
public class 打家劫舍 {

    public int rob(int[] nums) {

        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;

    }

    @Test
    public void test() {
        int rob = rob(new int[]{2, 1, 1, 2});
        System.out.println(rob);
    }
}
