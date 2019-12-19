package com.chenguangli.cus.dubbo.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2019/12/18 23:25
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
