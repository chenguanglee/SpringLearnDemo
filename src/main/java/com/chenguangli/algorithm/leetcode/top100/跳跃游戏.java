package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/5 21:19
 */
public class 跳跃游戏 {

    public boolean canJump(int[] nums) {
        int k = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < k) {
                k++;
            } else {
                k = 1;
            }
        }
        return k==1;
    }

    @Test
    public void test() {
        boolean b = canJump(new int[]{1,1,1,0,4,5,6});
        System.out.println(b);
    }
}
