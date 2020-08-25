package com.chenguangli.advance.callback;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * @author chenguangli
 * @date 2020/7/5 16:18
 */
public class Store {

    @Getter
    @Setter
    private String name;

    public Store(String name) {
        this.name = name;
    }

    public String returnOrderGoodsInfo(OrderResult orderResult) {
        String[] s = {"订购中...", "订购失败", "即将发货!", "运输途中...", "已在投递"};
        Random random = new Random();
        int temp = random.nextInt(5);
        String s1 = s[temp];
        return orderResult.getOrderResult(s1);
    }
}
