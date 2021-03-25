package com.chenguangli.algorithm.leetcode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2021/1/6 22:03
 */
public class 复杂链表的复制_35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node head1 = head;
        Node pre = new Node(0);
        Node tail = pre;
        while (head1 != null) {
            Node node = new Node(head1.val);
            tail.next = node;
            map.put(head1, node);
            tail = node;
            head1 = head1.next;
        }
        Node head2 = head;
        Node pre1 = pre.next;
        while (head2 != null) {
            Node random = head2.random;
            Node node = map.get(random);
            pre1.random = node;
            head2 = head2.next;
            pre1 = pre1.next;
        }
        return pre.next;
    }
}
