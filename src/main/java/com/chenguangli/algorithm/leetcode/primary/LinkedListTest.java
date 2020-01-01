package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

public class LinkedListTest {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * title:删除链表中的节点
     * problem description:
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * 4->5->1->9
     * example:
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * title:删除链表的倒数第N个节点
     * problem description:
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * example:
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        int size = 0;
        ListNode point = pre;
        while (point != null) {
            point = point.next;
            size++;
        }
        point = pre;
        for (int i = 0; i < size - n; i++) {
            point = point.next;
        }
        point.next = point.next.next;
        return pre.next;
    }

    /**
     * title:反转链表
     * problem description:
     * 反转一个单链表
     * example:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * title:反转链表
     * problem description:
     * 反转一个单链表
     * example:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseListIte(ListNode head) {


        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;   // 下一个节点
        //1->2->3
        while (cur != null) {
            // 拿到原来链表head的下一个节点
            next = cur.next;
            // 把当前链表的下一个节点指向上一个节点也就是pre
            cur.next = pre;
            // 重置pre为当前链表节点
            pre = cur;
            // 重置当前节点
            cur = next;
        }
        // 返回反转后的链表 也就是pre 其实就是cur
        return pre;
    }

    /**
     * title:合并两个有序链表
     * problem description:
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * example:
     * 输入：1->2->4, 1->3->4->6
     * 输出：1->1->2->3->4->4->6
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    @Test
    public void testNode() {

        ListNode head = new ListNode(1);
        ListNode bNode = head;
        head.val = 2;
        ListNode newNode1 = createLinkedList("123");
        ListNode newNode2 = createLinkedList("1234");
        ListNode returnNode = mergeTwoLists(newNode1, newNode2);
        ListNode node1 = reverseListIte(newNode1);
        System.out.println(" ");
    }

    /**
     * 根据字符串创建一个链表
     *
     * @param str
     * @return
     */
    public ListNode createLinkedList(String str) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i = 0; i < str.length(); i++) {
            int node = str.charAt(i) - '0';
            ListNode addNode = new ListNode(node);
            head.next = addNode;
            head = head.next;
        }
        return pre.next;
    }


}
