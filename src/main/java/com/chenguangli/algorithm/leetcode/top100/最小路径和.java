package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/24 21:46
 */
public class 最小路径和 {

    public class DfsSolution {
        private int value = 0;

        public int minPathSum(int[][] grid) {
            dfs(grid, 0, 0, 0);
            return value;
        }


        public void dfs(int[][] grid, int x, int y, int res) {
            if (x >= grid.length || y >= grid[0].length) {
                return;
            }
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                if (value == 0) {
                    value = res + grid[x][y];
                } else {
                    value = res + grid[x][y] > value ? value : res + grid[x][y];
                }
                return;
            }
            res += grid[x][y];
            dfs(grid, x + 1, y, res);
            dfs(grid, x, y + 1, res);
        }

        @Test
        public void test() {
            int m = minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
            System.out.println(m);
        }
    }


    public class DpSolution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                    }
                }
            }

            return grid[grid.length - 1][grid[0].length - 1];
        }


    }

    @Test
    public void test() {
        DpSolution dpSolution = new DpSolution();
        int m =  dpSolution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(m);
    }


}
