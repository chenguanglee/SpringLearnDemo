package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/18 21:48
 */
public class 平衡二叉树2_55 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root) != -1;

    }

    public int recur(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recur(node.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
