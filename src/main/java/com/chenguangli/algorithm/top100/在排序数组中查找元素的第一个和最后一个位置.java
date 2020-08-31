package com.chenguangli.algorithm.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/26 20:56
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                first = mid;
                break;
            }
        }

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int[] res = new int[]{first, first};
        int a = first;
        while (--a >= 0) {
            if (nums[a] == target) {
                res[0] = a ;
            }
        }
        int b = first;
        while (++b < nums.length) {
            if (nums[b] == target) {
                res[1] = b;
            }
        }

        return res;
    }


    @Test
    public void test() {
        int[] ints = searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3);
        System.out.println(ints);
    }
}
