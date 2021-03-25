package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chenguangli
 * @date 2021/1/18 22:22
 */
public class 滑动窗口的最大值1_59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = 1 - k; i < nums.length; i++, j++) {
            if (j <= 0) {
                if (list.size() == 0) {
                    list.add(nums[i]);
                } else {
                    while (!list.isEmpty() && list.getLast() < nums[i]) {
                        list.removeLast();
                    }
                    list.add(nums[i]);
                }
                if (j == 0) {
                    res[j] = list.getFirst();
                }
            } else {
                if (list.getFirst() == nums[j-1]) {
                    list.removeFirst();
                }
                while (!list.isEmpty() && list.getLast() < nums[i]) {
                    list.removeLast();
                }
                list.add(nums[i]);
                res[j] = list.getFirst();
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(nums, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
