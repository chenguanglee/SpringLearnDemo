package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/27 15:01
 */
public class 翻转链表24 {

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 5000
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head =  next;
        }
        return pre;
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

        ListNode listNode = reverseList1(node);
        System.out.println();
    }
}
