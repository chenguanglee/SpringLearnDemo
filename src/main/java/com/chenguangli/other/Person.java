package com.chenguangli.other;

/**
 * @author chenguangli
 * @date 2021/1/23 16:10
 */
public interface Person {

    public static final int a=10;
    //JDK1.8
    default void sayHello(){
        System.out.println("Hello World");
    }
    public void say();
}
