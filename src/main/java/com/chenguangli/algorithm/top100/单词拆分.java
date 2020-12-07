package com.chenguangli.algorithm.top100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2020/11/30 22:30
 */
public class 单词拆分 {


    /**
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * <p>
     * 说明：
     * <p>
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return find(s,wordDict,new StringBuilder());
    }

    public boolean find(String s, List<String> wordDict, StringBuilder sb) {
        if (!s.startsWith(sb.toString())) {
            return false;
        }
        if (s.equals(sb.toString())) {
            return true;
        }

        for (String word : wordDict) {
            boolean b = find(s, wordDict, sb.append(word));
            if (b) {
                return true;
            } else {
                sb.delete(sb.length() - word.length(), sb.length());
            }
        }
        return false;
    }

    @Test
    public void test() {
        String s = "cat23";
        List<String> strings = Arrays.asList("cats");
        boolean b = wordBreak(s, strings);
        System.out.println(b);
    }
}
