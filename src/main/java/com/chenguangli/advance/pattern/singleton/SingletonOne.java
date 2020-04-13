package com.chenguangli.advance.pattern.singleton;

/**
 * @author chenguangli
 * @date 2020/3/30 23:29
 */
public class SingletonOne {

    //懒汉模式(线程安全和不安全两种)
    //volatile 两个作用:
    //1.保证线程的可见性
    //2.防止指令重排
    private static volatile SingletonOne instance = null;

    private SingletonOne() {
    }

    //双重校验锁
    public static SingletonOne getInstance() {
        if (instance == null) {
            synchronized (SingletonOne.class) {
                if (instance == null) {
                    instance = new SingletonOne();
                }
            }
        }
        return instance;
    }
}
