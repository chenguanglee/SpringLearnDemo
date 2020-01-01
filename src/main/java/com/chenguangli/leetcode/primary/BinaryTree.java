package com.chenguangli.leetcode.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2019/8/16 0:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BinaryTree {
    private BinaryTreeNode root;


    private void checkEmpty() {
        if (root == null) {
            throw new IllegalArgumentException("can not insert to a null tree,please make sure set value for root node!");
        }
    }

    public void insertLeftChild(BinaryTreeNode leftNode) {
        checkEmpty();
        root.setLeftNode(leftNode);
    }

    public void insertRightChild(BinaryTreeNode rightNode) {
        checkEmpty();
        root.setRightNode(rightNode);
    }

    public void deleteNode(BinaryTreeNode node) {
        checkEmpty();
        if (node == null) {
            return;
        }
        deleteNode(node.getLeftNode());
        deleteNode(node.getRightNode());
        node = null;
    }

    public void clear() {
        if (root != null) {
            deleteNode(root);
        }
    }

    public int getTreeHeight() {
        return getHeight(root);
    }

    public int getHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftChildHeight = getHeight(node.getLeftNode());
        int rightChildHeight = getHeight(node.getRightNode());
        int max = leftChildHeight > rightChildHeight ? leftChildHeight : rightChildHeight;
        return max + 1;
    }

    public int getSize() {
        return getChildSize(root);
    }

    public int getChildSize(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftChildSize = getChildSize(node.getLeftNode());
        int rightChildSize = getChildSize(node.getRightNode());
        return leftChildSize + rightChildSize + 1;
    }

    /**
     * 前序遍历(根左右)
     *
     * @param node
     */
    public void firstOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        firstOrder(node.getLeftNode());
        firstOrder(node.getRightNode());
    }

    /**
     * 中序遍历(左根右)
     *
     * @param node
     */
    public void mediumOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        mediumOrder(node.getLeftNode());
        System.out.print(node.getData() + " ");
        mediumOrder(node.getRightNode());
    }

    /**
     * 中序遍历(左根右)非递归
     *
     * @param node
     */
    public void mediumOrderNoRecursive(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.getData() + " ");
                node = node.getRightNode();
            }
        }
    }

    /**
     * 后序遍历(左右根)
     *
     * @param node
     */
    public void lastOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        lastOrder(node.getLeftNode());
        lastOrder(node.getRightNode());
        System.out.println(node.getData());
    }
}
