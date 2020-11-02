package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2020/9/6 20:30
 */
public class 最小栈 {

    class MinStack {

        private Stack<Integer> stack;

        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.empty()) {
                minStack.push(x);
            } else {
                Integer peek = minStack.peek();
                if (x <= peek) {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (minStack.empty()) {
                return;
            } else {
                int peek = minStack.peek();
                if (peek == pop) {
                    minStack.pop();
                }
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if (minStack.empty()) {
                throw new RuntimeException("没有最小元素");
            }
            return minStack.peek();
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
