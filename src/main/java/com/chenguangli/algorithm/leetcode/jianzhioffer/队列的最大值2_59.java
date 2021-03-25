package com.chenguangli.algorithm.leetcode.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chenguangli
 * @date 2021/1/7 21:39
 */
public class 队列的最大值2_59 {

    class MaxQueue {
        private Queue<Integer> queue = new LinkedList<>();
        private LinkedList<Integer> maxQueue = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.get(0);
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && value > maxQueue.getLast()) {
                maxQueue.removeLast();
            }
            maxQueue.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int poll = queue.poll();
            if (poll == maxQueue.getFirst()) {
                maxQueue.removeFirst();
            }
            return poll;
        }
    }
}
