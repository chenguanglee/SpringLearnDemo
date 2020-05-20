package com.chenguangli.algorithm.leetcode.primary;

import lombok.Data;

/**
 * @author chenguangli
 * @date 2020/5/14 23:47
 */
@Data
public class DNode {

    private int val;
    private DNode pre;
    private DNode next;

    public static void main(String[] args) {
        DNode tail = new DNode();
        tail.setVal(1);

        DNode pred = tail;
        DNode newNode = new DNode();
        newNode.setVal(2);

        newNode.pre = pred;
        pred = newNode;
        //newNode = pred;
        pred.next = newNode;
        System.out.println(1);
    }
}
