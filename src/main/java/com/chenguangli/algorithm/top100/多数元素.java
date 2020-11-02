package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/6 20:41
 */
public class 多数元素 {

    public int majorityElement(int[] nums) {
        int a = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                a = nums[i];
                count++;
            } else {
                if (a == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return a;
    }

    @Test
    public void test() {
        int i = majorityElement(new int[]{3,2,3});
        System.out.println(i);
    }
}
