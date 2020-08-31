package com.chenguangli.spring.redis;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * Create by chenguangli on 2019/4/13 21:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisTest {


    private static final String KEY = "testKey";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void testTmpSetValue() {
        String value = "chenguangli";
        redisTemplate.opsForValue().set(KEY, value);
        //赋值list
        //redisTemplate.opsForList().set();
    }

    @Test
    public void testTmpGetValue() {
        String value = redisTemplate.opsForValue().get(KEY);
        System.out.println(value);

    }

    @Test
    public void testStrTmpSetValue() {
        String val = "lee";
        stringRedisTemplate.opsForValue().set(KEY, val);
    }

    @Test
    public void testStrTmpGetValue() {
        System.out.println(stringRedisTemplate.opsForValue().get(KEY));
    }

    @Test
    public void testJedis() {

        Jedis jedis = new Jedis("localhost",6379);
        String lee = jedis.set("lee", "123");
        String lee1 = jedis.get("lee");
        System.out.println(lee1);
        Long lee2 = jedis.del("lee");
        System.out.println(lee2);

    }
}
