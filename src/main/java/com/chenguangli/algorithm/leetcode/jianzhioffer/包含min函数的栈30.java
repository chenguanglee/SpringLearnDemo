package com.chenguangli.algorithm.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2021/1/3 15:15
 */
public class 包含min函数的栈30 {

    public static class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.empty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if (pop == minStack.peek()) {
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
}
