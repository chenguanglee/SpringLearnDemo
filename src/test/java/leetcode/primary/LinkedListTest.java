package leetcode.primary;

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

    @Test
    public void testNode() {
        ListNode node = new ListNode(1);
        ListNode pre = node;
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        pre.next = two;
        pre = pre.next;
        pre.next = three;
        ListNode node1 = reverseListIte(node);
        System.out.println(" ");
    }
}
