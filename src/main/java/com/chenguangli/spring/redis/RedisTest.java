package com.chenguangli.spring.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
