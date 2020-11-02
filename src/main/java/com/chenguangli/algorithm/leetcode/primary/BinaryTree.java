package com.chenguangli.algorithm.leetcode.primary;

import lombok.Data;

import java.util.*;

/**
 * @author chenguangli
 * @date 2019/8/16 0:04
 */

@Data
public class BinaryTree {
    private BinaryTreeNode root;


    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

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
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param node
     * @return
     */
    public boolean isValidBST(BinaryTreeNode node) {
        return false;
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * <p>
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *
     * @param node
     * @return
     */
    public boolean isSymmetric(BinaryTreeNode node) {
        return isMirror(node, node);
    }

    private boolean isMirror(BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return (leftNode.getData() == rightNode.getData())
                && isMirror(leftNode.getLeftNode(), rightNode.getRightNode())
                && isMirror(leftNode.getRightNode(), rightNode.getLeftNode());
    }

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                BinaryTreeNode node = queue.poll();
                list.add(node.getData());
                if (node.getLeftNode() != null) {
                    queue.offer(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    queue.offer(node.getRightNode());
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder0(BinaryTreeNode root) {
        foreachLevel(root, 0);
        return list;
    }

    public void foreachLevel(BinaryTreeNode node, int dep) {
        if (node == null) {
            return;
        }
        if (list.size() <= dep) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.getData());
            list.add(temp);
        } else {
            list.get(dep).add(node.getData());
        }
        foreachLevel(node.getLeftNode(), dep + 1);
        foreachLevel(node.getRightNode(), dep + 1);
    }

    public void insert2BalanceBinaryTree(BinaryTreeNode node) {
        if (root == null) {
            root = node;
        }

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
        System.out.println(node.getData() + " ");
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
        System.out.print(node.getData() + " ");
    }

    /**
     * 二叉树的左右子树交换
     *
     * @param node
     */
    public void exchangeBinaryTree(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        BinaryTreeNode temp = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(temp);
        exchangeBinaryTree(node.getLeftNode());
        exchangeBinaryTree(node.getRightNode());
    }

    public void mediumOrderNotRecursion(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.println(node.getData());
                node = node.getRightNode();
            }
        }

    }
}
