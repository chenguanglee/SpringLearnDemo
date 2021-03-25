package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/11/3 21:10
 */
public class 前K个高频元素 {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     * <p>
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *  
     * <p>
     * 提示：
     * <p>
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int[] array = new int[map.size()];
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[c++] = entry.getKey();
        }
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap1(array, i, length - 1, map);
        }
        int[] res = new int[k];
        int s = 0;
        for (int i = array.length - 1; i > array.length - k - 1; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            res[s++] = array[i];
            adjustHeap1(array, 0, i, map);
        }
        return res;

    }

    public void adjustHeap1(int[] nums, int begin, int end, Map<Integer, Integer> map) {
        int temp = nums[begin];
        for (int i = begin * 2 + 1; i < end; i = i * 2 + 1) {
            if (i + 1 < end && map.get(nums[i]) < map.get(nums[i + 1])) {
                i++;
            }
            if (map.get(nums[i]) > map.get(temp)) {
                nums[begin] = nums[i];
                begin = i;
            } else {
                break;
            }
        }
        nums[begin] = temp;
    }

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int p = getP(nums, left, right);
            sort(nums, left, p - 1);
            sort(nums, p + 1, right);
        }
    }

    public int getP(int[] nums, int left, int right) {
        int k = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
        int t = nums[left];
        nums[left] = nums[k - 1];
        nums[k - 1] = t;
        return k - 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 6, 6, 7, 8, 8};
        int[] ints = topKFrequent(nums, 2);
        System.out.println();
    }


    public void heapSort(int[] nums) {
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, length - 1);
        }
    }

    public void adjustHeap(int[] nums, int begin, int end) {
        int temp = nums[begin];
        for (int i = begin * 2 + 1; i < end; i = i * 2 + 1) {
            if (i + 1 < end && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > temp) {
                nums[begin] = nums[i];
                begin = i;
            } else {
                break;
            }
        }
        nums[begin] = temp;
    }

}
