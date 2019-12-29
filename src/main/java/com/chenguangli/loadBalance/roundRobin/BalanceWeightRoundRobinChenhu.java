package com.chenguangli.loadBalance.roundRobin;

import com.chenguangli.loadBalance.ServerIps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2019/12/28 23:51
 */
public class BalanceWeightRoundRobinChenhu {

    private static Map<String, int[]> map = new HashMap<>();

    //当前
    private static String currentIp;

    //上一次
    private static String lastIp;

    static {
        for (Map.Entry<String, Integer> entry : ServerIps.WEIGHT_MAP.entrySet()) {
            int[] integers = new int[ServerIps.WEIGHT_MAP.size()];
            int index = 0;
            for (Map.Entry<String, Integer> entry1 : ServerIps.WEIGHT_MAP.entrySet()) {
                integers[index++] = entry1.getValue();
            }
            map.put(entry.getKey(), integers);
            currentIp = entry.getKey();
        }

    }

    public static String getServers() {


        return null;
    }


}



