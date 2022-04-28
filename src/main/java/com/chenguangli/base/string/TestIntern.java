package com.chenguangli.base.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenguangli
 * @date 2020/1/5 12:07
 */
@Slf4j
public class TestIntern {

    public static void main(String[] args) {


        log.debug("123");
        //1.6版本 false
        /**
         * str2.intern()会把首次遇到的字符串实例复制到永久代中，返回的是永久代中实例的引用
         * str2创建的字符串在堆上, 两者不相同
         */

        //1.7+版本 true
        /**
         * str2.intern() 不会复制实例，只是在常量池中记录首次出现的实例的引用
         * 所以两者相同
         */
        String str2 = new StringBuilder("LEE").append("KING").toString();
        System.out.println(str2.intern() == str2);

        //1.6版本 false
        /**
         * 字符串 "java" 不属于首次出现, 所以str1.intern()返回的是在永久代的对象的引用
         * str在堆上，所以返回false
         */
        //1.7+版本 false
        /**
         * str1.intern()返回的是常量池中记录首次出现在堆上的实例的引用
         * str1重新new了, 所以false
         */
        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);


    }
}
