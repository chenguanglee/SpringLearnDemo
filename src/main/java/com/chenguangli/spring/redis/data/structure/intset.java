package com.chenguangli.spring.redis.data.structure;

/**
 * @author chenguangli
 * @date 2020/9/15 0:55
 */
public class intset {

    short encoding;

    short length;

    int[] contents;

}
