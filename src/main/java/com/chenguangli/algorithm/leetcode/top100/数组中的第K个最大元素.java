package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/12/18 20:56
 */
public class 数组中的第K个最大元素 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * <p>
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeapSort(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeapSort(nums, 0, i);
        }
        return nums[nums.length - k];
    }

    public void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeapSort(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeapSort(nums, 0, i);
        }
    }

    public void adjustHeapSort(int[] nums, int k, int j) {
        int cur = k;
        for (int i = k * 2 + 1; i < j; i = i * 2 + 1) {
            if (i + 1 < j && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > nums[cur]) {
                int temp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = temp;
                cur = i;
            } else {
                break;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
}
