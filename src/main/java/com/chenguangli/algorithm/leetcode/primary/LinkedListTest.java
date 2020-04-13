package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        ListNode newNode1 = createLinkedList("999");
        ListNode newNode2 = createLinkedList("11");
        addTwoNumbers(newNode1, newNode2);
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

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = head;
        //当前相加后该位的结果
        int a = 0;
        //十位的结果
        int b = 0;
        while (l1 != null || l2 != null || b != 0) {
            int l1val = 0;
            int l2val = 0;
            if (l1 != null) {
                l1val = l1.val;
            }
            if (l2 != null) {
                l2val = l2.val;
            }
            int i = l1val + l2val + b;
            a = i;
            if (i > 9) {
                a = i % 10;
                b = i / 10;
            } else {
                b = 0;
            }
            if (head == null) {
                head = new ListNode(a);
                pre = head;
            } else {
                pre.next = new ListNode(a);
                pre = pre.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    /**
     * 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * <p>
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> integers = reversePrint1(head);
        int[] res = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            res[i] = integers.get(i);
        }
        return res;
    }

    public List<Integer> reversePrint1(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        List<Integer> list = reversePrint1(head.next);
        list.add(head.val);
        return list;
    }


    /**
     * 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * <p>
     * 返回删除后的链表的头节点。
     * <p>
     * 注意：此题对比原题有改动
     * <p>
     * 示例 1:
     * <p>
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * <p>
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        while (pre != null && pre.next != null) {
            ListNode next = pre.next;
            if (next.val == val) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return res.next;
    }

    /**
     * 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
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
        ListNode pre = head;
        int count = 0;
        while (pre != null) {
            count++;
            pre = pre.next;
        }
        ListNode kthFromEnd1 = getKthFromEnd1(head, k, count);
        return kthFromEnd1;
    }

    /**
     * 使用快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null) {
            k--;
            if (k < 1) {
                s = s.next;
            }
            f = f.next;
        }
        return s;
    }

    public ListNode getKthFromEnd1(ListNode head, int k, int length) {
        if (head == null) {
            return null;
        }
        ListNode kthFromEnd1 = getKthFromEnd1(head.next, k, length - 1);
        if (k + 1 <= length) {
            return kthFromEnd1;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList1(head.next);
        ListNode node = head.next;
        head.next = null;
        node.next = head;
        return listNode;
    }


    /**
     * 两个链表的第一个公共节点
     * 输入两个链表，找出它们的第一个公共节点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode preA = headA;
        ListNode preB = headB;
        int headALength = 0;
        int headBLength = 0;
        while (preA != null) {
            preA = preA.next;
            headALength++;
        }
        while (preB != null) {
            preB = preB.next;
            headBLength++;
        }
        if (headALength > headBLength) {
            int step = headALength - headBLength;
            while (step-- != 0) {
                headA = headA.next;
            }
        } else {
            int step = headBLength - headALength;
            while (step-- != 0) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    @Test
    public void testCommon() {
        ListNode newNode1 = createLinkedList("12345");
        ListNode newNode1Tmp = getLastNode(newNode1);
        ListNode newNode2 = createLinkedList("345");
        ListNode newNode2Tmp = getLastNode(newNode2);
        ListNode commonNode = createLinkedList("67");

        newNode1Tmp.next = commonNode;
        newNode2Tmp.next = commonNode;

        ListNode intersectionNode = getIntersectionNode(newNode1, newNode2);

    }

    public ListNode getLastNode(ListNode node) {
        while (node != null){
            ListNode next = node.next;
            if (next == null) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    @Test
    public void testKthFromEnd() {
        ListNode newNode = createLinkedList("12345");
        getKthFromEnd(newNode, 10);
    }

    @Test
    public void testDeleteNode() {
        ListNode newNode = createLinkedList("4");
        ListNode listNode = deleteNode(newNode, 4);
        System.out.println();
    }

    @Test
    public void testReversePrint() {
        ListNode newNode1 = createLinkedList("132");
        int[] ints = reversePrint(null);
        System.out.println(ints);
    }

}
