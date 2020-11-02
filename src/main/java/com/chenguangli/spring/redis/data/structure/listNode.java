package com.chenguangli.spring.redis.data.structure;

/**
 * @author chenguangli
 * @date 2020/9/15 0:49
 */
public class listNode<T> {

    listNode<T> pre;

    listNode<T> next;

    T vale;
}
