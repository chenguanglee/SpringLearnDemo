package com.chenguangli.loadBalance.hash;

import com.chenguangli.loadBalance.ServerIps;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash
 *
 * @author chenguangli
 * @date 2019/12/28 13:27
 */
public class ConsistentHash {

    private static TreeMap<Integer, String> virtualNode = new TreeMap<>();

    private static final int VIRTUAL_NODES = 120;

    static {
        for (String ip : ServerIps.LIST) {

            for (int i = 0; i < VIRTUAL_NODES; i++) {
                int hash = getHash(ip + i);
                virtualNode.put(hash, ip);
            }

        }
    }

    public static int getHash(String key) {
        HashCode hashCode = Hashing.sha256().hashBytes(key.getBytes());
        return hashCode.asInt() > 0 ? hashCode.asInt() : -hashCode.asInt();
    }


    public static String getServer(String client) {
        int hash = getHash(client);
        SortedMap<Integer, String> sortedMap = virtualNode.tailMap(hash);
        Integer integer = sortedMap.firstKey();
        if (integer == null) {
            integer = virtualNode.firstKey();
        }
        return virtualNode.get(integer);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer("client"));
        }
    }
}
