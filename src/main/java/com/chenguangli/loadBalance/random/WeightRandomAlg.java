package com.chenguangli.loadBalance.random;

import com.chenguangli.loadBalance.ServerIps;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

/**
 * 加权随机
 *
 * @author chenguangli
 * @date 2019/12/28 11:22
 */
public class WeightRandomAlg {

    @Nullable
    public static String getServer() {
        //总权重
        int totalWeight = 0;
        for (Integer weight : ServerIps.WEIGHT_MAP.values()) {
            totalWeight += weight;
        }

        Random random = new Random();
        int offset = random.nextInt(totalWeight);
        for (Map.Entry<String, Integer> entry : ServerIps.WEIGHT_MAP.entrySet()) {
            if (offset < entry.getValue()) {
                return entry.getKey();
            }
            offset = offset - entry.getValue();
        }
        return null;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(getServer());
        }
    }
}
