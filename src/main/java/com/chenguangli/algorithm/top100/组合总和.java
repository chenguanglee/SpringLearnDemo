package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/9/4 21:03
 */
public class 组合总和 {

    private List<List<Integer>> res;

    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.target = target;
        dfs(candidates, new LinkedList<>(), 0, 0);
        return res;
    }

    public void dfs(int[] candidates, LinkedList<Integer> list, int sum, int currentIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = currentIndex; i < candidates.length; i++) {
            int cur = candidates[i];
            list.add(cur);
            dfs(candidates, list, sum + cur, i);
            list.removeLast();
        }
    }


    @Test
    public void test() {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
