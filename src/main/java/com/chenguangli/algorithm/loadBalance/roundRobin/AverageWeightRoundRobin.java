package com.chenguangli.algorithm.loadBalance.roundRobin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 平均加权轮询
 */
public class AverageWeightRoundRobin {
    private static Map<String, Integer> ipMap = new HashMap<>();
    private static Map<String, Integer> currentIpMap = new HashMap<>();
    private static LinkedList<String> ipList = new LinkedList<>();
    private static LinkedList<String> currentIpList = new LinkedList<>();

    /**下一个机器 */
    private static int nextIpSite;

    static {
        ipMap.put("A", 3);
        ipMap.put("B", 5);
        ipMap.put("C", 2);
        for (Map.Entry<String, Integer> entry :
                ipMap.entrySet()) {
            ipList.add(entry.getKey());
        }
        reInit();
    }

    private static void reInit() {
        currentIpMap.putAll(ipMap);
        currentIpList.addAll(ipList);
    }

    public static String getIp() {
        nextIpSite = nextIpSite >= currentIpList.size() ? 0 : nextIpSite;
        String ip = currentIpList.get(nextIpSite++);
        int count = currentIpMap.get(ip);
        if (count != 0) {
            currentIpMap.put(ip, --count);
            return ip;
        } else {
            if (currentIpList.size() != 0) {
                currentIpList.remove(ip);
                if (currentIpList.size() == 0){
                    nextIpSite = 0;
                    reInit();
                }
            }
            return getIp();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(getIp());
            if (i == 9){
                System.out.println();
            }
        }
    }
}
