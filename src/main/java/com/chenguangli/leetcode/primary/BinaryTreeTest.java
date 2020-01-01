package com.chenguangli.leetcode.primary;

import com.chenguangli.bean.BinaryTree;
import com.chenguangli.bean.BinaryTreeNode;
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
        String firstOrder = "1245736";
        String mediumOrder = "4275136";
        System.out.println(mediumOrder.substring(0, 1));
        System.out.println(mediumOrder.substring(1));
        System.out.println(firstOrder.substring(firstOrder.length()));
        BinaryTreeNode node = reConstruct(firstOrder, mediumOrder);
        BinaryTree tree = new BinaryTree(node);
        tree.firstOrder(node);
        System.out.println();
        tree.mediumOrder(node);
        System.out.println();
        System.out.println("use no recursive");
        tree.mediumOrderNoRecursive(node);
    }
}
