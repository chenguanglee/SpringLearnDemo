package com.chenguangli.loadBalance.roundRobin;

import com.chenguangli.loadBalance.ServerIps;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询
 *
 * @author chenguangli
 * @date 2019/12/28 12:36
 */
public class RoundRobinAlg {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static String getServer() {

        if (atomicInteger.get() == ServerIps.LIST.size()) {
            atomicInteger.set(0);
        }
        return ServerIps.LIST.get(atomicInteger.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
