package com.chenguangli.base.thread;

/**
 * @author chenguangli
 * @date 2020/9/15 23:39
 */
public class ThreadJoin {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1");
        });

        Thread t2 = new Thread(()->{

            System.out.println("t2");
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
