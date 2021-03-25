package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2021/1/3 10:53
 */
public class 链表中倒数第K个节点22 {

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * <p>
     * 返回链表 4->5.
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode point1 = head;
        ListNode point2 = head;
        for (int i = 0; i < k; i++) {
            point1 = point1.next;
        }

        while (point1 != null) {
            point1 = point1.next;
            point2 = point2.next;
        }
        return point2;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode kthFromEnd = getKthFromEnd(node, 1);
        System.out.println();
    }
}
