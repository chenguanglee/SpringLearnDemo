package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/19 23:49
 */
public class 数组中数字出现的次数2 {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int c = 0;
        int a = 1;
        for (int i = 0; i < 32; i++) {
            int res = 0;
            for (int k = 0; k < nums.length; k++) {
                if ((nums[k]&a) != 0){
                    res++;
                }
            }
            if (res % 3 != 0) {
                c ^= a;
            }
            a <<= 1;
        }
        return c;
    }

    @Test
    public void test() {
        int[] nums = {9,1,7,9,7,9,7};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}
