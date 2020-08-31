package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/31 22:48
 */
public class 合并二叉树 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        TreeNode left = mergeTrees(t1.left, t2.left);
        node.left = left;
        TreeNode right = mergeTrees(t1.right, t2.right);
        node.right = right;
        return node;
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.buildTree1();
        TreeNode node1 = TreeNode.buildTree2();
        TreeNode treeNode = mergeTrees(node, node1);
        System.out.println();
    }
}
