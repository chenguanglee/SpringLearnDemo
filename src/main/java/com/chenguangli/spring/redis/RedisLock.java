package com.chenguangli.spring.redis;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author chenguangli
 * @date 2020/8/26 22:01
 */
public class RedisLock {

    /**
     * 上锁
     *
     * @param key
     * @return
     */
    public static String lock(String key) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            String value = fetchLockValue();
            if ("ok".equals(jedis.setnx(key, value))) {
                jedis.expire(key, 10);
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean unLock(String key, String value) {
        if (key == null || value == null) {
            return true;
        }
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost", 6379);
            if (jedis.exists(key) && jedis.get(key).equals(value)) {
                jedis.del(key);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 获取唯一value
     *
     * @return
     */
    public static String fetchLockValue() {
        return UUID.randomUUID().toString() + "_" + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        String key = "订单号";
        String value = lock(key);
        try {
            //to do something
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            unLock(key, value);
        }

    }
}
