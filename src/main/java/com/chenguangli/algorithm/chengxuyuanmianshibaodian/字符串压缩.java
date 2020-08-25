package com.chenguangli.algorithm.chengxuyuanmianshibaodian;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/8/18 22:11
 */
public class 字符串压缩 {

    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < S.length()) {
            if (S.charAt(j) == S.charAt(i)) {
                j++;
                if (j != S.length()) {
                    continue;
                }
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;

        }
        if (sb.length() >= S.length()) {
            return S;
        } else {
            return sb.toString();
        }
    }

    @Test
    public void test() {
        String aabcccccaaa = compressString("bb");
        System.out.println(aabcccccaaa);
    }
}
