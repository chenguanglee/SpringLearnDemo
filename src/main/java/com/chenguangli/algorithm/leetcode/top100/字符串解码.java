package com.chenguangli.algorithm.leetcode.top100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author chenguangli
 * @date 2020/11/19 22:30
 */
public class 字符串解码 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * <p>
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     * <p>
     * 输入：s = "abc3[c2[d]]xyz"
     * 输出："abccdcdcdxyz"
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stackStr = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                count = 10 * count + Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                stackInt.push(count);
                count = 0;
                stackStr.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int num = stackInt.pop();
                String str = stackStr.pop();
                for (int i1 = 0; i1 < num; i1++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(str + tmp.toString());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String decodeString2(String s) {
        return dfs(s, 0)[0];
    }

    /**
     * c3[c2[d]]xyz
     * String[0] = count;
     * String[1] = str;
     *
     * @param s
     * @param k
     * @return
     */
    private String[] dfs(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                count = 10 * count + Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                String[] res = dfs(s, i + 1);
                String num = res[0];
                String reStr = res[1];
                int i1 = Integer.parseInt(num);
                for (int i2 = 0; i2 < count; i2++) {
                    sb.append(reStr);
                }
                i = i1;
            } else if (c == ']') {
                return new String[]{String.valueOf(i), sb.toString()};
            } else {
                sb.append(c);
            }
        }
        return new String[]{sb.toString()};
    }

    @Test
    public void test() {
        String s = decodeString("c3[c2[d]]xyz");
        String s1 = decodeString2("c3[c2[d]]xyz");
        //abc cddcddcddxyz
        System.out.println(s);
        System.out.println(s1);
    }
}
