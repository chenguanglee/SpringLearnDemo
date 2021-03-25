package com.chenguangli.algorithm.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/9/10 21:51
 */
public class 找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            int count = map.get(nums[i]);
            map.put(nums[i], ++count);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                list.add(key);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        boolean[] b = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            b[nums[i]] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < b.length; i++) {
            if (!b[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
