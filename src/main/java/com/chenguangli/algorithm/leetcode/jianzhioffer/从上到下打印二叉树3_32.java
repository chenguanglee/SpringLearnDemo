package com.chenguangli.algorithm.leetcode.jianzhioffer;

import java.util.*;

/**
 * @author chenguangli
 * @date 2021/1/3 15:41
 */
public class 从上到下打印二叉树3_32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            if (res.size() % 2 == 0) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
