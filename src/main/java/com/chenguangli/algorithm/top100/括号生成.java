package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2020/8/22 21:49
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }


    public void dfs(String s, int left, int right, List<String> res) {

        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(s + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(s + ")", left, right - 1, res);
        }
    }

    @Test
    public void test() {
        List<String> strings = generateParenthesis(4);
        System.out.println(strings);
    }
}
