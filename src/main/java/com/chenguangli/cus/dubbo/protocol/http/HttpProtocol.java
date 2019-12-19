package com.chenguangli.cus.dubbo.protocol.http;

import com.chenguangli.cus.dubbo.protocol.framework.Invocation;
import com.chenguangli.cus.dubbo.protocol.framework.Protocol;
import com.chenguangli.cus.dubbo.protocol.framework.URL;

/**
 * @author chenguangli
 * @date 2019/12/19 23:52
 */
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostName(), url.getPort(), invocation);
    }
}
