package com.chenguangli.algorithm.lru;

import lombok.Data;

/**
 * @author chenguangli
 * @date 2019/9/7 10:41
 */
@Data
public class DLinkedNode {

    private String key;
    private int value;
    private DLinkedNode pre;
    private DLinkedNode post;
}
