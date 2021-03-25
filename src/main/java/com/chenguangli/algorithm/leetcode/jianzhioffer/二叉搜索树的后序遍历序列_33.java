package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2021/1/12 21:24
 */
public class 二叉搜索树的后序遍历序列_33 {

    /**
     * [1,3,2,6,5]
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder1(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder1(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int m = i;
        while (postorder[m] < postorder[j]) {
            m++;
        }
        int k = m;
        while (postorder[m] > postorder[j]) {
            m++;
        }

        return m == j && verifyPostorder1(postorder, i, k - 1) && verifyPostorder1(postorder, k, j - 1);
    }

}
