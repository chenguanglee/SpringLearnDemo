package com.chenguangli.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2019/12/14 10:46
 */
public class CusHashMapTest {

    public static void main(String[] args) {

        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("123","123");
        CusHashMap<String, String> map = new CusHashMap<>(8);

        for (int i = 0; i < 10; i++) {
            map.put("lee" + i, "1995" + i);
        }
        System.out.println(map.get("lee2"));
    }
}
