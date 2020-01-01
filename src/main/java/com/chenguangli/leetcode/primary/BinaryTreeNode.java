package com.chenguangli.leetcode.primary;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenguangli
 * @date 2019/8/15 23:58
 */
@AllArgsConstructor
@Data
public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

}
