package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;
import org.springframework.util.StringUtils;

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
