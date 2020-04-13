package com.chenguangli.algorithm.leetcode.primary;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2020/4/8 22:25
 */
public class CQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2;

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.empty()) {
            return -1;
        }
        s2 = new Stack<>();
        while (!s1.empty()) {
            if (s1.size() == 1) {
                int target = s1.pop();
                while (!s2.empty()) {
                    s1.push(s2.pop());
                }
                return target;
            }
            s2.push(s1.pop());
        }
        return -1;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(3);
        System.out.println();
    }
}
