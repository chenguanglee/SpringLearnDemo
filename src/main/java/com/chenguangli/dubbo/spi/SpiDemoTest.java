package com.chenguangli.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author chenguangli
 * @date 2020/9/4 0:24
 */
public class SpiDemoTest {

    @Test
    public void test1() {
        ExtensionLoader<SpiDemoInterface> loader = ExtensionLoader.getExtensionLoader(SpiDemoInterface.class);
        SpiDemoInterface adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?spi.demo.interface=dubbo");
        System.out.println(adaptiveExtension.echo("1",url));
    }

    /**
     * 1. 在类上加上@Adaptive注解的类，是最为明确的创建对应类型Adaptive类。所以他优先级最高。
     * 2. @SPI注解中的value是默认值，如果通过URL获取不到关于取哪个类作为Adaptive类的话，就使用这个默认值，当然如果URL中可以获取到，就用URL中的。
     * 3. 可以再方法上增加@Adaptive注解，注解中的value与链接中的参数的key一致，链接中的key对应的value就是spi中的name,获取相应的实现类。
     */
}
