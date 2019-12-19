package com.chenguangli.cus.dubbo.protocol.framework;

/**
 * @author chenguangli
 * @date 2019/12/19 23:50
 */
public interface Protocol {

    void start(URL url);

    String send(URL url, Invocation invocation);
}
