package com.chenguangli.spring.redis.data.structure;

/**
 * @author chenguangli
 * @date 2020/9/15 0:50
 */
public class dictht {

    dictEntry table;

    long size;

    long sizemask;

    long uses;

    private class dictEntry<K, V> {
        K k;
        V v;
        dictEntry<K, V> next;
    }
}
