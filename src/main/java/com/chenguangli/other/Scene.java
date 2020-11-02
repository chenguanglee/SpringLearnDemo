package com.chenguangli.other;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenguangli
 * @date 2020/9/20 18:01
 */
public class Scene {


    public class Master {

        public void make() {

        }
    }

    public class Saller {

        public void work() {

        }

        public void collectMoney(CreateOrderReq req) {

        }


    }

    @Data
    @AllArgsConstructor
    public static class Good {
        private int type;
        private String desc;
    }

    @Data
    public class CreateOrderReq {

        private int type;

        private long money;

    }

    @Data
    public class CreateOrderRsp {
        private String token;
    }

    public class MealInfo {

    }

    public class Shop {

        private List<Good> list = new ArrayList<>();

        private Map<Integer, Good> map = new HashMap<>();

        private Map<Integer, Integer> stockInfo = new ConcurrentHashMap<>();

        private Master master;

        private Saller saller;

        public Shop() {
            Good tea = new Good(1, "奶茶");
            Good sausage = new Good(2, "烤肠");
            Good bread = new Good(3, "面包");
            list.add(tea);
            list.add(sausage);
            list.add(bread);
            map.put(tea.getType(), tea);
            map.put(sausage.getType(), sausage);
            map.put(bread.getType(), bread);
            stockInfo.put(tea.getType(), 0);
            stockInfo.put(sausage.getType(), 0);
            stockInfo.put(bread.getType(), 0);
            master = new Master();
            saller = new Saller();
        }


        public List<Good> getMenu() {
            return list;
        }

        public Map<Integer, Integer> getStock() {
            return stockInfo;
        }

        public CreateOrderRsp createOrder(CreateOrderReq req) {
            int type = req.getType();
            long money = req.getMoney();
            if (map.get(type) == null) {
                throw new RuntimeException("不支持的商品!");
            }
            return null;

        }

        public void takeMeals(String token) {

        }


    }
}
