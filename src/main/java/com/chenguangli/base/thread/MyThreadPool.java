package com.chenguangli.base.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenguangli
 * @date 2020/7/4 15:29
 */
public class MyThreadPool {
    private static final int DEFAULT_MAX_CONCURRENT = Runtime.getRuntime().availableProcessors() * 2;

    private static final String THREAD_POOL_NAME = "chenguangli-thread-pool-";

    private static final ThreadFactory FACTORY = new CusThreadFactory(THREAD_POOL_NAME);

    private static ExecutorService executorService;

    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);

    static {
        try {
            executorService = new ThreadPoolExecutor(DEFAULT_MAX_CONCURRENT, DEFAULT_MAX_CONCURRENT + 2, 60, TimeUnit.SECONDS, queue, FACTORY);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("my thread pool shutdown now!");
                    executorService.shutdown();

                    try {
                        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                            System.out.println("my thread pool shutdown wait timeout");
                            executorService.shutdownNow();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("my thread pool shutdown exception");
                        executorService.shutdownNow();
                    }
                    System.out.println("my thread pool shutdown complete");
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execute(Runnable runnable) {
        executorService.execute(runnable);
    }


    public static void main(String[] args) {
        MyThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute!!");
            }
        });
    }
}


class CusThreadFactory implements ThreadFactory {


    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    public CusThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}
