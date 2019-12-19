package com.chenguangli.cus.dubbo.protocol.netty;

import com.chenguangli.cus.dubbo.protocol.framework.Invocation;
import com.chenguangli.cus.dubbo.protocol.framework.Protocol;
import com.chenguangli.cus.dubbo.protocol.framework.URL;

/**
 * @author chenguangli
 * @date 2019/12/19 23:59
 */
public class NettyProtocol implements Protocol {
    @Override
    public void start(URL url) {

    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}
