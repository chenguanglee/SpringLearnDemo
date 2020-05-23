package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/5/21 22:46
 */
public class 二叉搜索树与双向链表 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = null, pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        change(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void change(Node root) {
        if (root == null) {
            return;
        }
        change(root.left);
        if (head == null) {
            head = root;
            pre = root;
        } else {
            root.left = pre;
            pre.right = root;
            pre = root;
        }
        change(root.right);
    }


    @Test
    public void test() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        Node node = treeToDoublyList(root);
        System.out.println();
    }
}
