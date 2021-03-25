package com.chenguangli.algorithm.leetcode.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/12/22 21:29
 */
public class 和为s的连续正数序列2_57 {

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     * <p>
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= target <= 10^5
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        return null;
    }

    public int[][] solution1(int target) {
        int j = 1;
        int k = 2;
        int sum = j + k;
        List<int[]> res = new ArrayList<>();
        while (j <= target / 2) {
            if (sum > target) {
                sum -= j;
                j++;
            } else if (sum < target) {
                k++;
                sum += k;
            } else {
                int[] a = new int[k - j + 1];
                for (int i = j; i <= k; i++) {
                    a[i - j] = j;
                }
                res.add(a);
                k++;
                sum += k;
            }
        }
        return res.toArray(new int[0][]);
    }
}
