package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.*;

/**
 * @author chenguangli
 * @date 2020/11/25 22:08
 */
public class 根据身高重建队列 {


    /**
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
     * <p>
     * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
     * <p>
     * 示例：
     * <p>
     * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * [7,0] [7,1] [6,1] [5,0] [5,2] [4,4]
     * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);


        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);

    }

    @Test
    public void test() {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        System.out.println();
    }
}
