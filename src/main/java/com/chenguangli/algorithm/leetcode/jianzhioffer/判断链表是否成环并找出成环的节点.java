package com.chenguangli.algorithm.leetcode.jianzhioffer;

import lombok.Data;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenguangli
 * @date 2020/8/5 21:12
 */
public class 判断链表是否成环并找出成环的节点 {

    class ListNode {
        private int val;
        private ListNode next;


        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }

    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode.next = listNode1;
        listNode3.next = listNode1;

        ListNode listNode4 = detectCycle(listNode);
        System.out.println(listNode4.val);
    }
}
