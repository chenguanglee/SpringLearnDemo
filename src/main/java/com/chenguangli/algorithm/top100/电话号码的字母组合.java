package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/8/23 23:19
 */
public class 电话号码的字母组合 {

    private static Map<Integer, String> map = new HashMap<Integer, String>() {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(new StringBuilder(), digits, 0, res);
        return res;
    }

    public void dfs(StringBuilder sb, String digits, int n, List<String> res) {
        if (n == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int c = Integer.parseInt(String.valueOf(digits.charAt(n)));
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(sb, digits, n + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    @Test
    public void test() {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

}
