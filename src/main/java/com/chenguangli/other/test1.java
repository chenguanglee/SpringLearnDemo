package com.chenguangli.other;

import java.util.Scanner;

/**
 * @author chenguangli
 * @date 2021/1/5 23:14
 */
public class test1 {
    static volatile boolean flag = true;

    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始休眠");
                try {
                    Thread.sleep(100 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束休眠，开始死循环");
                while (flag) {
                }
                System.out.println("------------------子线程结束------------------");
            }
        });
        thread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入1抛出一个中断异常，输入2修改循环标志位，输入3判断线程是否阻塞，输入其他结束Scanner\n");
        while (scanner.hasNext()) {
            String text = scanner.next();
            System.out.println("你输入了：" + text + "\n");
            if ("1".equals(text)) {
                thread.interrupt();
            } else if ("2".equals(text)) {
                flag = false; //如果不设为false，主线程结束后子线程仍在运行
            } else if ("3".equals(text)) {
                System.out.println(thread.isInterrupted());
            } else {
                scanner.close();
                break;
            }
        }
        System.out.println("------------------主线程结束------------------");


    }
}
