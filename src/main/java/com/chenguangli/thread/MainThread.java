package com.chenguangli.thread;

import java.util.concurrent.*;

/**
 * @author chenguangli
 * @date 2019/10/23 23:01
 */
public class MainThread {

    public static void main(String[] args) {
//        LiftOff liftOff = new LiftOff();
//        liftOff.run();
        System.out.println("123");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1; i++) {
            executorService.execute(new LiftOff());
        }
        Future future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });

        executorService.shutdown();
    }
}
