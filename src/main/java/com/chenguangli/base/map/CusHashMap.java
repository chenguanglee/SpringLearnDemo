package com.chenguangli.base.map;

/**
 * @author chenguangli
 * @date 2019/12/14 10:32
 */
public class CusHashMap<K, V> {


    private Entry<K, V>[] table;

    private int size;

    private static final int INTI_SIZE = 8;


    public CusHashMap() {
        this.table = new Entry[INTI_SIZE];
    }

    public CusHashMap(int size) {
        this.table = new Entry[size];
    }


    public V put(K k, V v) {
        int hash = k.hashCode();
        hash = hash < 0 ? -hash : hash;
        int index = hash % table.length;

        Entry<K, V> entry = new Entry<>(k, v, table[index]);
        table[index] = entry;
        size++;
        return table[index].v;
    }

    public V get(K k) {
        int hash = k.hashCode();
        hash = hash < 0 ? -hash : hash;
        int index = hash % table.length;
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.getNext()) {
            if (entry.getK().equals(k)) {
                return entry.getV();
            }
        }
        return null;
    }

    static class Entry<K, V> {
        K k;
        V v;
        Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }
}
