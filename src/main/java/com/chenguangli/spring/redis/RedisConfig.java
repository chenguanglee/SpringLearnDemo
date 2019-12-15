package com.chenguangli.spring.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Create by chenguangli on 2019/4/13 21:24
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisCF() {
        System.out.println("set redis connection info");

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1",6379);
        JedisConnectionFactory cf = new JedisConnectionFactory(configuration);
        //also can use  LettuceConnectionFactory
        //LettuceConnectionFactory lf = new LettuceConnectionFactory();
//        cf.setHostName();
//        cf.setPort(6379);
        return cf;
    }


    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redis = new RedisTemplate<>();
        redis.setConnectionFactory(cf);
        return redis;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf) {
        return new StringRedisTemplate(cf);
    }

}
