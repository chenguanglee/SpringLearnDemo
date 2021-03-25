package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/3 22:53
 */
public class 青蛙跳台阶问题2_10 {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     * <p>
     * 输入：n = 0
     * 输出：1
     * 提示：
     * <p>
     * 0 <= n <= 100
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        //f(n) = f(n-1)+f(n-2)
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}
