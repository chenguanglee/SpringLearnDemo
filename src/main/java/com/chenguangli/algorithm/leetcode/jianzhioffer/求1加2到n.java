package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/19 23:12
 */
public class 求1加2到n {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: n = 3
     * 输出: 6
     * 示例 2：
     * <p>
     * 输入: n = 9
     * 输出: 45
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {

        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;

        return n;
    }

    @Test
    public void test() {
        int i = sumNums(9);
        System.out.println(i);

    }
}
