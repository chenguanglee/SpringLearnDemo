package com.chenguangli.lru;

import java.util.Hashtable;

/**
 * @author chenguangli
 * @date 2019/9/7 10:42
 */
public class LRUCache {

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();

    private int count;

    private int capacity;

    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.setPre(null);

        tail = new DLinkedNode();
        tail.setPost(null);

        head.setPost(tail);
        tail.setPre(head);
    }

    public int get(String key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            throw new RuntimeException("the key not exist!");
        }
        moveToHead(node);
        return node.getValue();
    }

    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {

            node = new DLinkedNode();
            node.setKey(key);
            node.setValue(value);
            addNode(node);
            count++;
            if (count > capacity) {
                DLinkedNode removeNode = popTail();
                cache.remove(removeNode.getKey());
                addNode(node);
                count--;
            }
        } else {
            node.setValue(value);
            moveToHead(node);
        }
    }


    private void addNode(DLinkedNode node) {
        node.setPre(head);
        head.getPost().setPre(node);
        node.setPost(head.getPost());
        head.setPost(node);
    }


    private void removeNode(DLinkedNode node) {
        DLinkedNode preNode = node.getPre();
        DLinkedNode postNode = node.getPost();
        preNode.setPost(postNode);
        postNode.setPre(preNode);
    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.getPre();
        removeNode(node);
        return node;
    }
}
