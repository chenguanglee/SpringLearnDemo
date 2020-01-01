package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    /**
     * title:从排序数组中删除重复项
     * problem description：
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * example：
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }

    /**
     * title:买卖股票的最佳时机 II
     * problem description:
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * example:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;

    }

    /**
     * title:旋转数组
     * problem description:
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * example:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < nums.length; j++) {
                int a = nums[j];
                nums[j] = nums[0];
                nums[0] = a;

            }

        }
    }

    /**
     * title:存在重复
     * problem description:
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * example:
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * title:只出现一次的数字
     * problem description:
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * example:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] ^ nums[i];
        }
        return nums[nums.length - 1];

    }


    /**
     * title:两个数组的交集 II
     * problem description:
     * 给定两个数组，编写一个函数来计算它们的交集。
     * example:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> rstList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    rstList.add(nums1[i]);
                    nums2[j] = -1;
                    nums1[i] = -1;
                    break;
                }
            }
        }
        int[] rst = new int[rstList.size()];
        for (int k = 0; k < rstList.size(); k++) {
            rst[k] = rstList.get(k);
        }
        return rst;

    }

    /**
     * title:加一
     * problem description:
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * example:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        if (digits.length == 1 && digits[0] == 9) {
            return new int[]{1, 0};
        }
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
        }
        if (digits[0] == 10) {
            int[] rst = new int[digits.length + 1];
            rst[0] = 1;
            return rst;
        }

        return digits;

    }

    /**
     * title:移动零
     * problem description:
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * example:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j - 1] == 0) {
                    int k = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = k;
                }
            }

        }


    }


    /**
     * title:两数之和
     * problem description:
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * example:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * title:二维数组的查找
     * problem description：
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int column = 0;
        int row = array[0].length - 1;
        while (row >= 0 && column < array.length)
            if (array[row][column] > target) {
                row--;
            } else if (array[row][column] < target) {
                column++;
            } else {
                return true;
            }
        return false;
    }

    public boolean find1(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int column = array.length - 1;
        int row = 0;
        while (row < array[0].length && column >= 0)
            if (array[row][column] > target) {
                column--;
            } else if (array[row][column] < target) {
                row++;
            } else {
                return true;
            }
        return false;
    }

    @Test
    public void testFind() {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[][] array3=new int[3][];
        System.out.println(array3.length);
        int[][] array2 = {
                {1, 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 27, 30, 32, 35, 36, 38, 39, 42, 44, 46, 47, 48, 49, 51, 54, 55, 56},
                {3, 4, 6, 8, 11, 13, 15, 18, 19, 20, 23, 25, 27, 29, 33, 36, 38, 41, 42, 45, 48, 50, 53, 54, 57, 60, 63, 65, 66, 67},
                {5, 7, 8, 11, 14, 15, 17, 19, 21, 23, 24, 28, 31, 33, 36, 39, 41, 44, 47, 49, 52, 53, 56, 57, 60, 63, 66, 68, 71, 72},
                {7, 10, 13, 14, 17, 19, 22, 25, 26, 27, 30, 32, 34, 37, 39, 42, 44, 46, 50, 53, 55, 56, 59, 61, 64, 66, 69, 72, 74, 76},
                {8, 12, 16, 17, 20, 21, 23, 26, 29, 31, 33, 35, 37, 40, 42, 45, 48, 49, 52, 55, 58, 59, 61, 63, 67, 69, 70, 74, 76, 79},
                {10, 15, 18, 20, 22, 24, 27, 30, 32, 33, 36, 38, 39, 41, 45, 47, 50, 53, 56, 58, 61, 64, 65, 68, 69, 71, 73, 76, 79, 82},
                {13, 17, 20, 23, 24, 26, 28, 31, 34, 36, 38, 41, 42, 43, 48, 50, 53, 56, 58, 61, 64, 67, 68, 71, 73, 74, 75, 78, 81, 84},
                {15, 19, 22, 24, 26, 28, 31, 34, 35, 38, 41, 44, 45, 46, 49, 51, 56, 59, 61, 64, 67, 69, 71, 73, 76, 78, 79, 82, 85, 87},
                {17, 20, 23, 26, 29, 30, 32, 37, 40, 42, 43, 47, 50, 53, 55, 56, 58, 62, 64, 66, 69, 72, 75, 78, 80, 81, 83, 86, 88, 90},
                {18, 21, 25, 28, 30, 32, 35, 38, 42, 43, 44, 49, 51, 55, 58, 59, 61, 65, 68, 71, 73, 74, 77, 79, 82, 85, 88, 89, 91, 93},
                {20, 23, 28, 29, 33, 36, 37, 40, 43, 45, 47, 52, 55, 58, 60, 62, 63, 66, 70, 74, 76, 77, 79, 81, 85, 88, 89, 91, 93, 94},
                {23, 25, 31, 33, 35, 39, 42, 43, 44, 46, 50, 53, 56, 61, 62, 65, 68, 69, 72, 75, 78, 81, 82, 83, 88, 91, 92, 93, 96, 99},
                {26, 27, 33, 34, 38, 40, 45, 48, 51, 53, 55, 56, 58, 64, 66, 69, 72, 75, 77, 80, 82, 84, 87, 88, 90, 93, 94, 95, 99, 101},
                {29, 30, 36, 38, 40, 42, 47, 50, 53, 56, 57, 59, 62, 65, 68, 71, 73, 77, 79, 83, 84, 86, 88, 91, 93, 96, 99, 100, 102, 103},
                {32, 33, 39, 42, 44, 46, 49, 53, 56, 59, 62, 65, 68, 71, 72, 75, 77, 78, 80, 85, 87, 90, 92, 94, 96, 99, 101, 103, 105, 107},
                {35, 37, 42, 43, 46, 48, 51, 55, 59, 61, 65, 67, 71, 74, 76, 78, 81, 82, 84, 86, 90, 92, 95, 96, 99, 102, 103, 106, 107, 109},
                {36, 39, 43, 46, 49, 50, 53, 58, 62, 65, 67, 70, 73, 76, 77, 79, 84, 87, 88, 90, 93, 96, 99, 102, 103, 106, 108, 111, 112, 115},
                {38, 42, 45, 47, 52, 55, 57, 60, 64, 66, 69, 72, 75, 78, 80, 82, 87, 89, 91, 92, 94, 99, 100, 103, 105, 107, 111, 112, 115, 118},
                {39, 44, 48, 49, 55, 57, 60, 63, 66, 69, 72, 75, 78, 80, 82, 85, 89, 92, 94, 95, 98, 101, 102, 105, 108, 111, 112, 115, 116, 120},
                {40, 47, 49, 52, 56, 59, 63, 64, 68, 71, 75, 78, 80, 83, 85, 88, 91, 94, 97, 99, 101, 104, 105, 108, 110, 112, 115, 118, 120, 123},
                {42, 50, 53, 55, 59, 62, 66, 67, 71, 73, 78, 81, 82, 86, 87, 90, 94, 97, 100, 101, 104, 106, 107, 109, 111, 114, 117, 120, 123, 126},
                {43, 51, 55, 58, 62, 64, 69, 71, 74, 77, 81, 84, 86, 87, 89, 93, 96, 99, 102, 103, 105, 108, 111, 112, 113, 116, 120, 122, 125, 129},
                {45, 54, 56, 59, 65, 67, 72, 75, 76, 79, 84, 87, 90, 92, 94, 97, 99, 102, 104, 107, 108, 111, 114, 116, 119, 120, 122, 124, 127, 132},
                {47, 55, 59, 62, 66, 68, 74, 78, 80, 82, 85, 88, 93, 96, 99, 101, 102, 105, 106, 108, 110, 113, 115, 118, 120, 121, 124, 127, 130, 133},
                {49, 56, 61, 65, 68, 70, 76, 81, 83, 85, 87, 91, 95, 99, 102, 103, 104, 106, 108, 110, 113, 116, 118, 121, 124, 127, 130, 133, 134, 137},
                {51, 57, 62, 68, 71, 74, 78, 83, 86, 89, 92, 95, 97, 101, 104, 106, 108, 110, 113, 114, 117, 119, 121, 123, 126, 130, 132, 135, 137, 140},
                {53, 59, 65, 69, 73, 75, 81, 86, 88, 92, 95, 97, 100, 103, 107, 109, 111, 112, 115, 117, 120, 122, 125, 126, 129, 131, 133, 138, 141, 143},
                {55, 61, 67, 72, 75, 77, 82, 89, 92, 94, 97, 100, 102, 105, 108, 111, 114, 115, 116, 119, 123, 125, 126, 128, 131, 134, 137, 140, 144, 146},
                {57, 63, 68, 74, 78, 81, 85, 90, 95, 98, 100, 101, 103, 107, 110, 114, 117, 119, 120, 123, 126, 129, 130, 133, 136, 138, 141, 144, 146, 149},
                {58, 65, 70, 76, 81, 84, 86, 93, 98, 101, 104, 105, 107, 110, 112, 115, 120, 122, 124, 126, 129, 132, 135, 136, 138, 140, 142, 146, 149, 150}};
        System.out.println(find1(102, array2));
    }
}
