package com.chenguangli.advance.classloader.bean;

/**
 * <功能描述></功能描述>
 *
 * @author: chenhu
 * @date: 2020/1/5 18:48
 */
public class DeadLoopClass {
    static {
        /**
         * 如果不加上这个if语句，编译器会提示"Initializer must be able to complete normally"
         */
        if (true) {
            System.out.println(Thread.currentThread() + "DeadLoopClass.static initializer");
            while (true) {
            }
        }
    }
}
