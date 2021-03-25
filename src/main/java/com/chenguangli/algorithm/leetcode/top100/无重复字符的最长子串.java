package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author chenguangli
 * @date 2020/8/18 23:04
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        while (j < s.length()) {
            if (linkedList.contains(s.charAt(j))) {
                linkedList.removeFirst();
                i++;
            } else {
                linkedList.add(s.charAt(j));
                j++;
                max = max > j - i ? max : j - i;
            }
        }
        return max;
    }

    @Test
    public void test() {
        //cbfcmnop
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }
}
