package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2020/8/22 0:22
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        boolean xi = false;
        int li = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (xi && li == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            boolean xj = false;
            boolean xk = false;
            int lj = 0;
            int lk = 0;
            while (j < k && j < nums.length && k >= 0) {
                if (xj && lj == nums[j]) {
                    j++;
                    continue;
                }
                if (xk && lk == nums[k]) {
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    xj = true;
                    xk = true;
                    lj = nums[j];
                    lk = nums[k];
                    j++;
                    k--;
                } else if (sum > 0) {
                    xk = true;
                    lk = nums[k];
                    k--;
                } else {
                    xj = true;
                    lj = nums[j];
                    j++;
                }
            }
            xi = true;
            li = nums[i];
        }

        return lists;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(lists);
    }
}
