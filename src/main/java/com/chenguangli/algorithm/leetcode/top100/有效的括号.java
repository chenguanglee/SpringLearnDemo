package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author chenguangli
 * @date 2020/8/19 21:25
 */
public class 有效的括号 {


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                list.add(current);
                continue;
            }
            if (list.isEmpty()) {
                return false;
            }
            Character last = list.getLast();
            if (last == null) {
                return false;
            }
            if (current == ')') {
                if (last == '(') {
                    list.removeLast();
                    continue;
                }
                return false;
            } else if (current == '}') {
                if (last == '{') {
                    list.removeLast();
                    continue;
                }
                return false;
            } else {
                if (last == '[') {
                    list.removeLast();
                    continue;
                }
                return false;
            }
        }
        return list.isEmpty();
    }

    @Test
    public void test() {
        boolean valid = isValid("){");
        System.out.println(valid);
    }
}