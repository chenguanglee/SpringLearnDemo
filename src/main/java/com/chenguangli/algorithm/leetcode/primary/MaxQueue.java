package com.chenguangli.algorithm.leetcode.primary;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/4/25 17:26
 */
public class MaxQueue {

    private List<Integer> linkedList = new LinkedList<>();
    private List<Integer> maxList = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        return maxList.size() == 0 ? -1 : maxList.get(0);
    }

    public void push_back(int value) {
        while (maxList.size() > 0 && (maxList.get(maxList.size() - 1) <value)) {
            maxList.remove(maxList.size() - 1);
        }
        maxList.add(value);
        linkedList.add(value);
    }

    public int pop_front() {
        if (linkedList.size() == 0) {
            return -1;
        }
        int pop = linkedList.remove(0);
        if (maxList.size() != 0) {
            if (pop == maxList.get(0)) {
                maxList.remove(0);
            }
        }
        return pop;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

    }
}
