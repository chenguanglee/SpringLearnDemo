package com.chenguangli.advance.classloader.bean;

/**
 * <功能描述>被动引用的父类</功能描述>
 * 被动使用父类的静态字段，不会导致子类的初始化
 *
 * @author: chenhu
 * @date: 2020/1/5 14:34
 */
public class SuperClass4CitationPassive {
    public static final String FINAL_VAR = "final 修饰的静态变量，在编译期存入该类的常量池中";
    public static String SUPER_VAR = "被动使用父类的静态字段，不会导致子类的初始化";

    static {
        System.out.println("SuperClass4CitationPassive init!");
    }

//    static {
//        i = 2;
//        System.out.println(i);
//    }
//    public static int i = 1;
}
