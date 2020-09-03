package com.chenguangli.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

/**
 * @author chenguangli
 * @date 2020/9/4 0:29
 */
@Adaptive
public class SpiDemoImpl3 implements SpiDemoInterface{

    @Override
    public String echo(String msg, URL url) {
        return "SpiDemoImpl3";
    }
}
