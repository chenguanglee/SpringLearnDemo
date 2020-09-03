package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/2 21:55
 */
public class 二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        if (left != null) {
            TreeNode right = root.right;
            root.right = left;
            root.left = null;
            while (left.right!=null){
                left = left.right;
            }
            left.right = right;
        }
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree3();
        flatten(treeNode);
        System.out.println();
    }
}
