package com.chenguangli.algorithm.leetcode.jianzhioffer;

import lombok.Data;
import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/4 21:15
 */
public class 判断链表是否成环 {

    @Data
    class ListNode {
        private int val;
        private ListNode next;


        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pre = head;
        ListNode nnext = head;
        while (nnext != null) {
            pre = pre.next;
            nnext = nnext.next;
            if (pre == null || nnext == null) {
                return false;
            }
            nnext = nnext.next;
            if (pre == nnext) {
                return true;
            }
        }
        return false;
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
        boolean b = hasCycle(listNode);
        System.out.println(b);

        ListNode listNode4 = new ListNode(3);
        boolean c = hasCycle(listNode4);
        System.out.println(c);

        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode5.next = listNode6;
        boolean d = hasCycle(listNode5);
        System.out.println(d);
    }
}
