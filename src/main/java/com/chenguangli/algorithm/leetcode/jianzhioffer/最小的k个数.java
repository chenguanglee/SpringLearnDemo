package com.chenguangli.algorithm.leetcode.jianzhioffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenguangli
 * @date 2020/5/23 14:52
 */
public class 最小的k个数 {


    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     * <p>
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[k];

        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        int x = 0;
        for (int i = arr.length - 1; i > arr.length - 1 - k; i--) {
            res[x++] = arr[0];
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        return res;
    }

    public void adjustHeap(int[] arr, int i, int j) {
        int c = arr[i];
        for (int k = i * 2 + 1; k < j; k = k * 2 + 1) {
            if (k + 1 < j && arr[k + 1] < arr[k]) {
                k++;
            }
            if (arr[k] < c) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = c;
    }

    @Test
    public void test() {
        int[] num = {2};
        int[] leastNumbers = getLeastNumbers(num, 1);
        System.out.println();

    }
}
