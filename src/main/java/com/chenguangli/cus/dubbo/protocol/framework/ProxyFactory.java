package com.chenguangli.cus.dubbo.protocol.framework;

import com.chenguangli.cus.dubbo.protocol.http.HttpProtocol;
import com.chenguangli.cus.dubbo.provider.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenguangli
 * @date 2019/12/19 23:27
 */
public class ProxyFactory {

    public static <T> T getProxy(Class clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocol protocol = ProtocolFactory.getProtocol();
                Invocation invocation = new Invocation(clazz.getName(), method.getName(), method.getParameterTypes(), args);

                URL url = RemoteMapRegister.getUrlRandom(clazz.getName());
                String result = protocol.send(url, invocation);
                System.out.println(result);
                return result;
            }
        });
    }
}
