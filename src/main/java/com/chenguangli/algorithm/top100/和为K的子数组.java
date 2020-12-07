package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/12/1 21:51
 */
public class 和为K的子数组 {


    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * <p>
     * 示例 1 :
     * <p>
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     * <p>
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        find(nums, 0, k);
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    private int count;

    public void find(int[] nums, int index, int k) {
        if (index >= nums.length) {
            return;
        }
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
        }
        find(nums, index + 1, k);
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1};
        int i = subarraySum1(nums, 2);
        System.out.println(i);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6,};
        System.out.println(calcChildArraySum(array, 5));
    }

    public static int calcChildArraySum(int[] array, int num) {
        int count = 0;
        int tmp = 0;
        Map<String, Integer> sumMap = new HashMap<>();
        for (int index = 0; index < array.length; index++) {
            count += dealWithData(sumMap, num, array, 0, index);
            for (int interval = index; interval < array.length - index; interval++) {
                int start = index + 1;
                int end = start + interval;
                while (end < array.length) {
                    count += dealWithData(sumMap, num, array, start, end);
                    start = end + 1;
                    end = start + interval;
                    tmp++;
                }
                if (start < array.length) {
                    count += dealWithData(sumMap, num, array, start, array.length - 1);
                }
            }
        }
        return count;
    }

    private static int dealWithData(Map<String, Integer> sumMap, int num, int[] array, int start, int end) {
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        while (start <= end) {
            builder.append(start).append("-");
            sum += array[start++];
        }
        String key = builder.toString();
        if (!sumMap.containsKey(key)) {
            sumMap.put(key, sum);
            if (sum == num) {
                return 1;
            }
        }
        return 0;
    }
}