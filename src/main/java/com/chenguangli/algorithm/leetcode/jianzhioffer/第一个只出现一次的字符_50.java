package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2021/1/20 21:35
 */
public class 第一个只出现一次的字符_50 {


    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char res = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                res = key;
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        char abaccdeff = firstUniqChar("abaccdeff");
        System.out.println(abaccdeff);
    }
}
