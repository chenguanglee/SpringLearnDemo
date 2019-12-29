package com.chenguangli.loadBalance.random;

import com.chenguangli.loadBalance.ServerIps;

import java.util.Random;

/**
 * 随机
 *
 * @author chenguangli
 * @date 2019/12/28 11:11
 */
public class RandomAlg {

    public static String getServer() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(ServerIps.LIST.get(random.nextInt(ServerIps.LIST.size())));
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            System.out.println(getServer());
        }
    }
}
