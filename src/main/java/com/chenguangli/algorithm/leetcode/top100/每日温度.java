package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/3 21:47
 */
public class 每日温度 {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int a = T[i];
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > a) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(ints);

    }
}
