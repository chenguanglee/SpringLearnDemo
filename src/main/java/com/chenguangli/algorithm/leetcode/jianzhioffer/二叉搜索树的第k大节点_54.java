package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/10 21:29
 */
public class 二叉搜索树的第k大节点_54 {

    private int k, res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        find(root);
        return res;
    }

    public void find(TreeNode node) {
        if (node == null) {
            return;
        }
        find(node.right);
        if (k == 0) return;
        if (--k == 0) res = node.val;
        find(node.left);
    }
}
