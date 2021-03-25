package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/28 21:52
 */
public class 旋转数组的最小数字11 {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：[2,2,2,0,1]
     * 输出：0
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int k = (i + j) / 2;
            if (numbers[k] > numbers[j]) {
                i = k + 1;
            } else if (numbers[k] < numbers[j]) {
                j = k;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 4, 2,2, 2};
        int i = minArray(nums);
        System.out.println(i);
    }
}
