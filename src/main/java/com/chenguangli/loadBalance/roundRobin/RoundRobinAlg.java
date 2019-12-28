package com.chenguangli.loadBalance.roundRobin;

import com.chenguangli.loadBalance.ServerIps;

/**
 * @author chenguangli
 * @date 2019/12/28 12:36
 */
public class RoundRobinAlg {

    private static int pos;

    public static String getServer() {

        String ip = ServerIps.LIST.get(pos);
        pos++;
        pos = pos % ServerIps.LIST.size();
        return ip;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
