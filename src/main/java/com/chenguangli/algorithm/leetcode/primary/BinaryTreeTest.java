package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树
 *
 * @author chenguangli
 * @date 2019/8/15 23:47
 */
public class BinaryTreeTest {

    /**
     * 根据前序和中序遍历获取后序遍历
     *
     * @param firstOrder
     * @param mediumOrder
     */
    public BinaryTreeNode reConstruct(String firstOrder, String mediumOrder) {
        if (StringUtils.isEmpty(firstOrder) || StringUtils.isEmpty(mediumOrder)) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(String.valueOf(firstOrder.charAt(0))), null, null);
        for (int i = 0; i < mediumOrder.length(); i++) {
            if (firstOrder.charAt(0) == mediumOrder.charAt(i)) {
                node.setLeftNode(reConstruct(firstOrder.substring(1, i + 1 > firstOrder.length() ? firstOrder.length() : i + 1), mediumOrder.substring(0, i)));
                node.setRightNode(reConstruct(firstOrder.substring(i + 1 > firstOrder.length() ? firstOrder.length() : i + 1), mediumOrder.substring(i + 1 > mediumOrder.length() ? mediumOrder.length() : i + 1)));
            }
        }
        return node;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        TreeNode node = new TreeNode(root);
        int[] leftPre, leftIn, rightPre, rightIn;
        int inLength = inorder.length;
        int preLength = preorder.length;
        for (int i = 0; i < inLength; i++) {
            if (inorder[i] == root) {
                leftPre = Arrays.copyOfRange(preorder, 1, i + 1 > preLength ? preLength : i + 1);
                leftIn = Arrays.copyOfRange(inorder, 0, i);
                rightPre = Arrays.copyOfRange(preorder, i + 1 > preLength ? preLength : i + 1, preLength);
                rightIn = Arrays.copyOfRange(inorder, i + 1 > inLength ? inLength : i + 1, inLength);
                node.left = buildTree(leftPre, leftIn);
                node.right = buildTree(rightPre, rightIn);
            }
        }
        return node;
    }


    /**
     * 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     * <p>
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     * <p>
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        change(root);
        return root;
    }

    public void change(TreeNode root) {
        if (root == null) {
            return;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    /**
     * 二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> integers = kthLargest1(root, new ArrayList<>());
        return integers.get(integers.size() - k);
    }

    public List<Integer> kthLargest1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        kthLargest1(root.left, list);
        list.add(root.val);
        kthLargest1(root.right, list);
        return list;
    }

    /**
     * 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 平衡二叉树
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int abs = Math.abs(left - right);
        return abs <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    @Test
    public void test2() {
        int[] pre = {1,2,3,4,2,3,4};
        int[] in = {4,3,2,1,2,3,4};
        TreeNode treeNode = buildTree(pre, in);
        boolean balanced = isBalanced(treeNode);
        int i = kthLargest(treeNode, 1);
        TreeNode treeNode1 = mirrorTree(treeNode);
        System.out.println();
    }


    @Test
    public void test1() {
        String firstOrder = "1245367";
        String mediumOrder = "4251637";
        BinaryTreeNode node = reConstruct(firstOrder, mediumOrder);
        BinaryTree tree = new BinaryTree(node);
        System.out.println("前序遍历");
        tree.firstOrder(node);
        System.out.println();
        System.out.println("中序遍历");
        tree.mediumOrder(node);
        System.out.println();
        System.out.println("后序遍历");
        tree.lastOrder(node);
        System.out.println();
        System.out.println("use no recursive 中序遍历");
        tree.mediumOrderNoRecursive(node);
        System.out.println();
        System.out.println("-----------");
        System.out.println("二叉树交换后的前序遍历结果");
        tree.exchangeBinaryTree(node);
        tree.firstOrder(node);
        System.out.println();
        System.out.println("二叉树交换后的中序遍历结果");
        tree.mediumOrder(node);

    }
}
