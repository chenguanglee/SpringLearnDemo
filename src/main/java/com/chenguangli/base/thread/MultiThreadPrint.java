package com.chenguangli.base.thread;

/**
 * @author chenguangli
 * @date 2020/9/15 22:49
 */
public class MultiThreadPrint {


    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i += 2) {
                    synchronized (MultiThreadPrint.class) {
                        MultiThreadPrint.class.notify();
                        System.out.println(i);
                        try {
                            if (i != 100) {
                                MultiThreadPrint.class.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i += 2) {
                    synchronized (MultiThreadPrint.class) {
                        MultiThreadPrint.class.notify();
                        System.out.println(i);
                        try {
                            if (i!=99){
                                MultiThreadPrint.class.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
