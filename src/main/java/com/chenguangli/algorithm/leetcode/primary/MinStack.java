package com.chenguangli.algorithm.leetcode.primary;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2020/4/12 20:01
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() > x) {
            minStack.push(x);
        }

    }

    public void pop() {
        int pop = stack.pop();
        if (pop == minStack.peek()){
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
