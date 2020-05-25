package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/5/25 21:52
 */
public class 把数组排成最小的数 {

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     * <p>
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *  
     * <p>
     * 提示:
     * <p>
     * 0 < nums.length <= 100
     * 说明:
     * <p>
     * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
     * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }


    @Test
    public void test() {
        int[] nums = {3};
        String s = minNumber(nums);
        System.out.println(s);
    }

    public void sort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int p = getP1(nums, left, right);
        sort(nums, left, p);
        sort(nums, p + 1, right);
    }

    public int getP(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[left]) {
                if (i != index) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
        int temp = nums[left];
        nums[left] = nums[index - 1];
        nums[index - 1] = temp;
        return index - 1;
    }

    public int getP1(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            String m = String.valueOf(nums[i]) + String.valueOf(nums[left]);
            String n = String.valueOf(nums[left]) + String.valueOf(nums[i]);
            if (m.compareTo(n) < 0) {
                if (i != index) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
        int temp = nums[left];
        nums[left] = nums[index - 1];
        nums[index - 1] = temp;
        return index - 1;
    }
}
