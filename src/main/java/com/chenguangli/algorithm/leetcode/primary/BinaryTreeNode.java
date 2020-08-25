package com.chenguangli.algorithm.leetcode.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenguangli
 * @date 2019/8/15 23:58
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

}
