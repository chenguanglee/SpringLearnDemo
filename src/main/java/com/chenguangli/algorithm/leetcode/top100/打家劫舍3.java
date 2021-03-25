package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * todo
 *
 * @author chenguangli
 * @date 2020/11/26 22:07
 */
public class 打家劫舍3 {

    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     *      3
     * / \
     * 4   5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;
            while (count > 0) {
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
                count--;
                sum += poll.val;
            }
            list.add(sum);
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        int[] dp = new int[list.size()];
        dp[0] = list.get(0);
        dp[1] = Math.max(list.get(1), dp[0]);
        for (int i = 2; i < list.size(); i++) {
            dp[i] = Math.max(dp[i - 2] + list.get(i), dp[i - 1]);
        }
        return dp[list.size() - 1];
    }


    @Test
    public void test() {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
