package com.chenguangli.loadBalance.roundRobin;

import com.chenguangli.loadBalance.ServerIps;

import java.util.Map;

/**
 * 加权轮询
 *
 * @author chenguangli
 * @date 2019/12/28 12:40
 */
public class WeightRoundRobin {

    private static int pos;

    private static int IP_LIST_SIZE;

    static {
        for (Integer weight : ServerIps.WEIGHT_MAP.values()) {
            IP_LIST_SIZE += weight;
        }
    }


    public static String getServer() {

        if (pos == IP_LIST_SIZE) {
            pos = 0;
        }
        int offset = pos;
        pos++;
        for (Map.Entry<String, Integer> entry : ServerIps.WEIGHT_MAP.entrySet()) {
            if (offset < entry.getValue()) {
                return entry.getKey();
            }
            offset -= entry.getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }
}
