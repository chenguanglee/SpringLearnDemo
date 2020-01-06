package com.chenguangli.advance.classloader;

import com.chenguangli.advance.classloader.bean.DeadLoopClass;
import org.junit.Test;

/**
 * <功能描述></功能描述>
 *
 * @author: chenhu
 * @date: 2020/1/5 19:20
 */
public class DeadLoopClassTest {
    @Test
    public void test(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "end");
            }
        };
        Thread threadA = new Thread(runnable,"Thread A");
        Thread threadB = new Thread(runnable,"Thread B");
        threadA.start();
        threadB.start();

    }

    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "end");
            }
        };
        Thread threadA = new Thread(runnable,"Thread A");
        Thread threadB = new Thread(runnable,"Thread B");
        threadA.start();
        threadB.start();

    }
}
