package com.chenguangli.algorithm.leetcode.jianzhioffer;

/**
 * @author chenguangli
 * @date 2020/12/27 13:44
 */
public class 替换空格5 {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= s 的长度 <= 10000
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
