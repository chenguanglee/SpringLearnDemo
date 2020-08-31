package com.chenguangli.algorithm.top100;

/**
 * @author chenguangli
 * @date 2020/8/30 11:19
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode buildTree1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node6.left = node7;
        node4.left = node6;
        node8.right = node9;
        node5.right = node8;
        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    public static TreeNode buildTree2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node6.left = node7;
        node4.left = node6;
        node5.right = node8;
        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node1.right = node3;
        return node1;
    }
}
