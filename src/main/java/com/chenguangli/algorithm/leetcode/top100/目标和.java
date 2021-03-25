package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/11/21 21:49
 */
public class 目标和 {

    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * <p>
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     * <p>
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * <p>
     * 一共有5种方法让最终目标和为3。
     *  
     * <p>
     * 提示：
     * <p>
     * 数组非空，且长度不会超过 20 。
     * 初始的数组的和不会超过 1000 。
     * 保证返回的最终结果能被 32 位整数存下。
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, 3);
        return count;
    }

    private int count;
    private LinkedList<Integer> list = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[] nums, int k, int sum, int target) {
        if (k >= nums.length) {
            if (sum == target) {
                count++;
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            int num;
            if (i == 0) {
                num = nums[k];
            } else {
                num = -nums[k];
            }
            list.add(num);
            dfs(nums, k + 1, sum + num, target);
            list.removeLast();
        }
    }

    @Test
    public void test() {
        findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }



    public static class Res {

        public int findTargetSumWays(int[] nums, int S) {
            dfs(nums, 0, 0, S);
            return count;
        }

        private int count;


        public void dfs(int[] nums, int k, int sum, int target) {
            if (k >= nums.length) {
                if (sum == target) {
                    count++;
                }
                return;
            }
            for (int i = 0; i < 2; i++) {
                int num;
                if (i == 0) {
                    num = nums[k];
                } else {
                    num = -nums[k];
                }
                dfs(nums, k + 1, sum + num, target);
            }
        }
    }
}
