package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/9 17:51
 */
public class 二叉树的深度1_55 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
