package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/6 21:02
 */
public class 排序链表 {

    public ListNode sortList(ListNode head) {
        ListNode q = head;
        while (q != null) {
            ListNode p = q.next;
            while (p != null) {
                if (p.val < q.val) {
                    int val = p.val;
                    p.val = q.val;
                    q.val = val;
                }
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode node = ListNode.buildNode();
        ListNode node1 = sortList(node);
        System.out.println(1);
    }
}
