package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/5 21:26
 */
public class 二叉搜索树的最近公共祖先1_68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
