package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/11/24 22:07
 */
public class 比特位计数 {

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     * <p>
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num >= 1) {
            res[1] = 1;
        }
        int now = 2;
        for (int i = 2; i <= num; i++) {
            if (i % now == 0) {
                res[i] = 1;
                now = i;
            } else {
                int i1 = i % now;
                res[i] = res[i1] + res[now];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] ints = countBits(17);
        System.out.println();
    }
}
