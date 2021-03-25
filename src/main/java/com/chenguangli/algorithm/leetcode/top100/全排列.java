package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2020/8/25 21:38
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new LinkedList<>(), res);
        return res;
    }

    public void dfs(int[] nums, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (list.contains(k)) {
                continue;
            }
            list.add(k);
            dfs(nums, list, res);
            list.removeLast();
        }
    }


    @Test
    public void test() {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
