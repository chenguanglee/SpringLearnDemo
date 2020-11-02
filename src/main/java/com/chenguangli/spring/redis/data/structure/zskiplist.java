package com.chenguangli.spring.redis.data.structure;

/**
 * @author chenguangli
 * @date 2020/9/15 0:52
 */
public class zskiplist {

    zskiplistNode header,tail;

    long length;

    int level;


    private class zskiplistNode {
        zskiplistNode backward;

        double score;
        zskiplistLevel[] levels;

        private class zskiplistLevel {
            zskiplistNode forward;
            int span;
        }
    }
}
