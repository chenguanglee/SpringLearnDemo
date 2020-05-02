package com.chenguangli.algorithm.leetcode.primary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 )
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * @author chenguangli
 * @date 2020/5/1 20:30
 */
public class LRUCache {

    private Map<Integer, Integer> map;

    private LinkedList<Integer> list;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>(2);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        } else {
            list.remove((Integer) key);
            list.addFirst(key);
            return value;
        }
    }

    public void put(int key, int value) {
        Integer oldValue = map.get(key);
        if (oldValue == null) {
            if (list.size() < capacity) {
                list.addFirst(key);
            } else {
                list.addFirst(key);
                Integer last = list.removeLast();
                map.remove(last);
            }
        } else {
            list.remove((Integer) key);
            list.addFirst(key);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));      // 返回  1
        System.out.println(cache.get(2));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
