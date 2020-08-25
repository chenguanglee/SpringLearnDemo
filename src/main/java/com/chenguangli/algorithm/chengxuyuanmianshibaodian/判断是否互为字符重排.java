package com.chenguangli.algorithm.chengxuyuanmianshibaodian;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/8/17 21:29
 */
public class 判断是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            if (map1.containsKey(c1)) {
                map1.put(c1, map1.get(c1) + 1);
            } else {
                map1.put(c1, 1);
            }

            char c2 = s2.charAt(i);
            if (map2.containsKey(c2)) {
                map2.put(c2, map2.get(c2) + 1);
            } else {
                map2.put(c2, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer num = entry.getValue();
            Integer num2 = map2.get(key);
            if (num2 == null || num2.intValue() != num) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        boolean b = CheckPermutation("abcc", "cab");
        System.out.println(b);
    }
}
