package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2020/8/30 11:02
 */
public class 二叉树的中序遍历 {


    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        middleOrder(root);
        return list;
    }

    public void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrder(root.left);
        list.add(root.val);
        middleOrder(root.right);
    }

    public List<Integer> inorderTraversalIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
            }
        }
        return list;
    }


    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree1();
        //middleOrder(treeNode);
        List<Integer> integers = inorderTraversalIterator(treeNode);
        System.out.println(integers);
    }
}
