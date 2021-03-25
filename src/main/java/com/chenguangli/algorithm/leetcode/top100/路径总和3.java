package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/11/29 22:43
 */
public class 路径总和3 {

    public int pathSum(TreeNode root, int sum) {
        pathSum0(root,sum);
        return count;
    }

    public void pathSum0(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        find(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
    }

    private int count=0;

    public void find(TreeNode root, int sum, int val) {
        if (root == null) {
            return;
        }
        val += root.val;
        if (val == sum) {
            count++;
        }
        find(root.left, sum, val);
        find(root.right, sum, val);
    }

    @Test
    public void test() {
        TreeNode t9 = new TreeNode(10);
        TreeNode t8 = new TreeNode(5);
        TreeNode t7 = new TreeNode(-3);
        TreeNode t6 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t4 = new TreeNode(11);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(-2);
        TreeNode t1 = new TreeNode(1);
        t9.left = t8;
        t9.right = t7;
        t8.left = t6;
        t8.right = t5;
        t6.left = t3;
        t6.right = t2;
        t5.right = t1;
        t7.right = t4;
        int i = pathSum(t9, 8);
        System.out.println(i);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
