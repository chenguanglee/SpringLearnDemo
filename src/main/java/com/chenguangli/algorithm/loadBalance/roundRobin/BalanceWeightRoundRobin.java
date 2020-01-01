package com.chenguangli.algorithm.loadBalance.roundRobin;

import com.chenguangli.algorithm.loadBalance.ServerIps;

import java.util.HashMap;
import java.util.Map;

/**
 * 平衡加权轮询
 *
 * @author chenguangli
 * @date 2019/12/28 12:58
 */
public class BalanceWeightRoundRobin {

    private static Map<String, Weight> map = new HashMap<>();

    //所有权重之和
    private static int WEIGHT_SUM;

    static {
        for (Integer weight : ServerIps.WEIGHT_MAP.values()) {
            WEIGHT_SUM += weight;
        }
    }

    public static String getServer() {
        if (map.isEmpty()) {
            for (Map.Entry<String, Integer> entry : ServerIps.WEIGHT_MAP.entrySet()) {
                map.put(entry.getKey(), new Weight(entry.getKey(), entry.getValue(), 0));
            }
        }

        for (Weight weight : map.values()) {
            weight.setCurrentWeight(weight.getWeight() + weight.getCurrentWeight());
        }

        Weight maxCurrentWeight = null;
        for (Weight weight : map.values()) {
            if (maxCurrentWeight == null || maxCurrentWeight.getCurrentWeight() < weight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }

        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - WEIGHT_SUM);

        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(getServer());
        }
    }
}
