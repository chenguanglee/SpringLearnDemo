package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenguangli
 * @date 2020/12/14 22:47
 */
public class 零钱兑换 {


    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：coins = [1], amount = 1
     * 输出：1
     * 示例 5：
     * <p>
     * 输入：coins = [1], amount = 2
     * 输出：2
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int begin = 0;
        int count = 0;
        if (amount < coins[coins.length - 1]) {
            return -1;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            if (coin == amount) {
                return 1;
            } else if (coin > amount) {
                begin = i - 1;
            } else {
                begin = i;
                break;
            }
        }
        if (begin < 0) {
            return -1;
        }

        return 0;
    }

    public void count(int[] coins, int begin, int amount) {
        if (amount == 0) {

        }
        for (int i = begin; i >= 0; i--) {

            count(coins, begin, amount - coins[i]);
        }
    }

    @Test
    public void test() {
        int[] coins = new int[]{1, 2, 4};
        coinChange(coins, 2);
    }
}
