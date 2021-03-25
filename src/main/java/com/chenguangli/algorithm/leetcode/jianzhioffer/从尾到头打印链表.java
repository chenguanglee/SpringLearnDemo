package com.chenguangli.algorithm.leetcode.jianzhioffer;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author chenguangli
 * @date 2020/12/27 13:46
 */
public class 从尾到头打印链表 {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 10000
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        re(head, res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void re(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        re(head.next, list);
        list.add(head.val);
    }
}
