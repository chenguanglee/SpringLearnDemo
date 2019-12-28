package com.chenguangli.loadBalance.random;

import com.chenguangli.loadBalance.ServerIps;

import java.util.Random;

/**
 * @author chenguangli
 * @date 2019/12/28 11:11
 */
public class RandomAlg {

    public static String getServer() {
        Random random = new Random();
        return ServerIps.LIST.get(random.nextInt(ServerIps.LIST.size()));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
