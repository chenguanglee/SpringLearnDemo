package com.chenguangli.dubbo.spi;

import com.alibaba.dubbo.common.URL;

/**
 * @author chenguangli
 * @date 2020/9/4 0:22
 */
public class SpiDemoImpl2 implements SpiDemoInterface{
    @Override
    public String echo(String msg, URL url) {
        return "SpiDemoImpl2";
    }
}
