package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/1 22:27
 */
public class 把二叉搜索树转换为累加树 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree3();
        TreeNode treeNode1 = convertBST(treeNode);
        System.out.println();
    }
}
