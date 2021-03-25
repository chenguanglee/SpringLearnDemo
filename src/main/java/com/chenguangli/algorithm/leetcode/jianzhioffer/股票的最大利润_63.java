package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2021/1/9 17:15
 */
public class 股票的最大利润_63 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
