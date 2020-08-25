package com.chenguangli.advance.callback;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chenguangli
 * @date 2020/7/5 16:19
 */
public class SyncBuyer implements OrderResult {

    @Getter
    @Setter
    private Store store;

    @Setter
    @Getter
    private String buyerName;

    @Getter
    @Setter
    private String goodsName;

    public SyncBuyer(Store store, String buyerName, String goodsName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }

    public String orderGoods() {
        String s = store.returnOrderGoodsInfo(this);
        System.out.println(s);
        System.out.println("some thing");
        return s;
    }

    @Override
    public String getOrderResult(String state) {
        return "在" + this.getStore().getName() + "商店订购的" + this.getGoodsName() + "玩具, 目前的预订状态是: " + state;
    }

    public static void main(String[] args) {
        Store store = new Store("壹方城");
        SyncBuyer syncBuyer = new SyncBuyer(store,"lee","霸气芝士草莓");
        System.out.println(syncBuyer.orderGoods());
    }
}
