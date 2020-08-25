package com.chenguangli.advance.callback;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chenguangli
 * @date 2020/7/5 16:25
 */
public class AsyncBuyer implements OrderResult {

    @Getter
    @Setter
    private Store store;

    @Setter
    @Getter
    private String buyerName;

    @Getter
    @Setter
    private String goodsName;

    public AsyncBuyer(Store store, String buyerName, String goodsName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }

    public String orderGoods() {
        String s = "--";
        s = store.returnOrderGoodsInfo(this);
        System.out.println(s);
        System.out.println("some thing");
        return s;
    }

    @Override
    public String getOrderResult(String state) {
        return "在" + this.getStore().getName() + "商店订购的" + this.getGoodsName() + "玩具, 目前的预订状态是: " + state;
    }

    class MyRunnable implements Runnable {

        @Setter
        @Getter
        private String result;

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                result =store.returnOrderGoodsInfo(AsyncBuyer.this);
            } catch (Exception e) {
                System.out.println("回调异常");
            }
        }
    }

}


