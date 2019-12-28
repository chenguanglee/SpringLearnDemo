package com.chenguangli.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2019/12/14 10:46
 */
public class CusHashMapTest {

    public static void main(String[] args) {

        int b = -1;
//        System.out.println(Integer.toBinaryString(b));
//        b = b >>>16;
//        System.out.println(Integer.toBinaryString(b));
        String a = new String("leeeeeeeeeeeeee");
        System.out.println(a);
        int h;
        System.out.println((h = a.hashCode()) ^ (h >>> 16));
        System.out.println(a.hashCode());
        a.equals(123);
        Map<String,String> hashMap = new HashMap<>(1);
        hashMap.put("123","123");
        CusHashMap<String, String> map = new CusHashMap<>(8);

        for (int i = 0; i < 10; i++) {
            map.put("lee" + i, "1995" + i);
        }
        System.out.println(map.get("lee2"));
    }
}
