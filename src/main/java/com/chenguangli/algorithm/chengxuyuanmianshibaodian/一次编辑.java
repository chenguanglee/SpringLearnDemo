package com.chenguangli.algorithm.chengxuyuanmianshibaodian;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/8/17 21:51
 */
public class 一次编辑 {

    public boolean oneEditAway(String first, String second) {
        if (first == null || first.length() == 0) {
            if (second == null) {
                return true;
            } else if (second.length() == 0 || second.length() == 1) {
                return true;
            } else {
                return false;
            }
        }

        if (second == null || second.length() == 0) {
            if (first.length() == 1) {
                return true;
            } else {
                return false;
            }
        }

        int f = first.length() - 1;
        int s = second.length() - 1;
        int i = 0;
        while (i <= f && i <= s && first.charAt(i) == second.charAt(i)) {
            i++;
        }

        while (f >= 0 && s >= 0 && first.charAt(f) == second.charAt(s)) {
            f--;
            s--;
        }

        return f - i < 1 && s - i < 1;
    }

    @Test
    public void test() {
        boolean b = oneEditAway("ABCDEF", "ABBBBCDEF");
        System.out.println(b);
    }
}
