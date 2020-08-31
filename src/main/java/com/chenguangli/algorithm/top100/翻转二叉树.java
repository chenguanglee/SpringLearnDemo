package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/30 12:52
 */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }

    public void inverse(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree1();
        TreeNode treeNode1 = invertTree(treeNode);
        System.out.println(1);
    }
}
