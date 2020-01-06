package com.chenguangli.advance.classloader.bean;

/**
 * <功能描述>被动引用子类</功能描述>
 *  被动使用父类的静态字段，不会导致子类的初始化
 *
 * @author: chenhu
 * @date: 2020/1/5 14:38
 */
public class SubClass4CitationPassive extends SuperClass4CitationPassive {
    static {
        System.out.println("SubClass4CitationPassive init!");
    }
}
