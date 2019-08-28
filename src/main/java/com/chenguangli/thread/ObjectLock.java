package com.chenguangli.thread;

/**
 * @author chenguangli
 * @date 2019/8/26 23:03
 */
public class ObjectLock implements Runnable {

    private final Object lock = new Object();

    private int count = 0;

    @Override
    public void run() {

        method();
    }


    public void method() {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + (count++));
            }
        }
    }

    public static void main(String[] args) {

        ObjectLock lockl = new ObjectLock();
        ObjectLock lock2 = new ObjectLock();
        Thread thread1 = new Thread(lockl);
        Thread thread2 = new Thread(lock2);
        thread1.start();
        thread2.start();
    }
}
