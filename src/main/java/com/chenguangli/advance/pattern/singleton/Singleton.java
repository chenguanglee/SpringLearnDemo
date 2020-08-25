package com.chenguangli.advance.pattern.singleton;

/**
 * 单例模式
 *
 * @author chenguangli
 */
class SingletonLazy {

    //懒汉模式(线程安全和不安全两种)
    private static volatile SingletonLazy instance = null;

    private SingletonLazy() {
    }

    //线程安全的
    public static synchronized SingletonLazy getInstanceSafe() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    //双重校验锁
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    //线程不安全的
    public static SingletonLazy getInstanceUnSafe() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

class SingletonHungry {

    //饿汉模式
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
    //如何保证线程安全？由JVM类加载的特性，JVM在加载类的时候，是单线程的，所以可以保证只存在单一的实例，不需要加synchronized
}

class SingletonInnerClass {

    //静态内部类
    private static class SingletonHolder {
        private static SingletonInnerClass instance = new SingletonInnerClass();
    }

    private SingletonInnerClass() {
    }

    public static SingletonInnerClass getInstance() {
        return SingletonHolder.instance;
    }

}

enum Signleton {
    INSTANCE;
}


public class Singleton {
}
