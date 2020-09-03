package com.chenguangli.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author chenguangli
 * @date 2020/9/3 23:07
 */
@SPI("cloud")
public interface SpiDemoInterface {

    @Adaptive
    String echo(String msg, URL url);
}
