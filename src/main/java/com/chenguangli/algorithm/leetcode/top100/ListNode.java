package com.chenguangli.algorithm.leetcode.top100;

/**
 * @author chenguangli
 * @date 2020/9/6 10:28
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static ListNode buildNode() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node;
    }
}
