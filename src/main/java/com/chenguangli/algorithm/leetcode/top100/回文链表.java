package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2020/9/6 10:27
 */
public class 回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p = head;
        ListNode q = head;

        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while (q != null) {
            ListNode pop = stack.pop();
            if (pop.val !=q.val){
                return false;
            }
            q = q.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    @Test
    public void test() {
        ListNode listNode = ListNode.buildNode();
        boolean palindrome = isPalindrome(listNode);
        System.out.println(palindrome);
    }
}
