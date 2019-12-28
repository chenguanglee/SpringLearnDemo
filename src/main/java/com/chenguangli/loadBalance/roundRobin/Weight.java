package com.chenguangli.loadBalance.roundRobin;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenguangli
 * @date 2019/12/28 13:13
 */
@Data
@AllArgsConstructor
public class Weight {

    private String ip;
    private int weight;
    private int currentWeight;
}
