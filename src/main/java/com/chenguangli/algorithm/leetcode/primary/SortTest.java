package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 排序算法
 *
 * @author chenguangli
 * @date 2019/5/16 22:57
 */
public class SortTest {


    @Test
    public void testSort() {
        int[] array = new int[]{10, 4, 2, 8, 15, 7};
        int[] array1 = {3, 2, 6, 5, 9};
        int[] targetArray;
        //targetArray = bubbleSort(array);
        //targetArray = selectionSort(array);
        //targetArray = insertSort(array);
        //targetArray = shellSort(array);
        targetArray = quickSort(array);
        for (int i = 0; i < targetArray.length; i++) {
            System.out.print(targetArray[i] + " ");
        }
    }

    /**
     * 冒泡排序, 从小到大
     *
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        //不改变原来数组
        int[] array0 = Arrays.copyOf(array, array.length);
        int length = array0.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (array0[j] > array0[j + 1]) {
                    int tmp = array0[j];
                    array0[j] = array0[j + 1];
                    array0[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array0;
    }


    /**
     * 选择排序, 从小到大
     *
     * @param array
     * @return
     */
    public int[] selectionSort(int[] array) {
        int[] array0 = Arrays.copyOf(array, array.length);
        int length = array0.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array0[i] > array0[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = array0[i];
                array0[i] = array0[minIndex];
                array0[minIndex] = tmp;
            }
        }
        return array0;
    }


    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public int[] insertSort(int[] array) {
        int[] array0 = Arrays.copyOf(array, array.length);
        int length = array0.length;
        for (int i = 1; i < length; i++) {
            int tmp = array0[i];
            int j = i;
            while (j > 0 && tmp < array0[j - 1]) {
                array0[j] = array0[j - 1];
                j--;
            }
            if (j != i) {
                array0[j] = tmp;
            }
        }
        return array0;
    }


    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public int[] shellSort(int[] array) {
        int[] array0 = Arrays.copyOf(array, array.length);
        int length = array0.length;
        int gap = 1;
        while (gap < length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = array0[i];
                int j = i - gap;
                while (j >= 0 && array0[j] > tmp) {
                    array0[j + gap] = array0[j];
                    j -= gap;
                }
                array0[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return array0;
    }

    public int[] shellSort0(int[] array) {
        int[] array0 = Arrays.copyOf(array, array.length);
        int length = array0.length;
        int gap = length;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = array0[i];
                int j = i - gap;
                while (j >= 0 && array0[j] > tmp) {
                    array0[j + gap] = array0[j];
                    j -= gap;
                }
                array0[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return array0;
    }


    /**
     * 快速排序
     *
     * @param array
     * @return
     */
    public int[] quickSort(int[] array) {
        int[] array0 = Arrays.copyOf(array, array.length);
        int length = array0.length;
        return quickSort0(array0, 0, length - 1);
    }

    public int[] quickSort0(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort0(array, left, partitionIndex - 1);
            quickSort0(array, partitionIndex + 1, right);
        }
        return array;
    }

    private int partition(int[] array, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, left, index - 1);
        return index - 1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 堆排序
     *
     * @param array
     * @return
     */
    public int[] heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustHeap(array, 0, i);
        }
        return array;
    }

    public void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }

    @Test
    public void testHeapSort() {
        int[] a = {10, 4, 2, 8, 15, 7};
        int[] ints = heapSort(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {
        sortM(array, 0, array.length - 1);
        return array;
    }

    public void sortM(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sortM(array, l, mid);
        sortM(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    public void merge(int[] array, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            temp[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }
        while (p2 <= r) {
            temp[i++] = array[p2++];
        }
        for (int k = 0; k < temp.length; k++) {
            array[l + k] = temp[k];
        }
    }

    @Test
    public void testMergeSort() {
        int[] array = {3, 5, 1, 4, 9, 7, 6};
        int[] ints = mergeSort(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
