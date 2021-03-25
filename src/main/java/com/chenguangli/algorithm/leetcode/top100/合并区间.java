package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenguangli
 * @date 2020/8/27 21:19
 */
public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ( o1[0] - o2[0] >0){
                    return 1;
                }else if ( o1[0] - o2[0] <0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int k = list.get(list.size() - 1)[0];
            int h = list.get(list.size() - 1)[1];
            int m = intervals[i][0];
            int n = intervals[i][1];
            if (h >= m) {
                list.remove(list.size() - 1);
                if (h>=n){
                    list.add(new int[]{k, h});
                }else {
                    list.add(new int[]{k, n});
                }
            } else {
                list.add(new int[]{m, n});
            }
        }
        return list.toArray(new int[0][0]);
    }

    @Test
    public void test() {
        int[][] merge = merge(new int[][]{{1, 4}, {2, 3}});
        //int[][] merge = merge(new int[][]{});
        System.out.println(merge);
    }
}
