package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/29 21:30
 */
public class 二叉树的直径 {


    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int val = left + right;
        max = max > val ? max : val;
        return Math.max(left, right) + 1;
    }

    @Test
    public void test() {
        TreeNode node1 = TreeNode.buildTree1();

        getHeight(node1);
        System.out.println(max);
        System.out.println(diameterOfBinaryTree(node1));

    }
}
