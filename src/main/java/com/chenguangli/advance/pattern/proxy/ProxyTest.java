package com.chenguangli.advance.pattern.proxy;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author chenguangli
 * @date 2019/4/21 11:42
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        System.out.println(CalculatorImpl.class.getName());
        System.out.println(Calculator.class.getName());
        //获取接口Calculator的代理类的类对象
        Class calculatorProxyClazz = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        System.out.println(calculatorProxyClazz.getName());
        Constructor[] constructors = calculatorProxyClazz.getConstructors();
        System.out.println("calculatorProxyClazz的构造器");
        printClassInfo(constructors);
        Method[] methods = calculatorProxyClazz.getMethods();
        System.out.println("calculatorProxyClazz的方法");
        printClassInfo(methods);
        //获取构造器
        Constructor constructor = calculatorProxyClazz.getConstructor(InvocationHandler.class);
        //通过构造器创建一个calculatorProxyClazz实例
        Calculator calculatorProxyImpl = (Calculator) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        int sum = calculatorProxyImpl.add(1, 2);
        System.out.println(sum);

    }

    public static class InvocationHandlerImpl implements InvocationHandler {
        private Object object;

        public InvocationHandlerImpl(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method.getName() + "方法开始执行---");
            Object result = method.invoke(object, args);
            System.out.println(result);
            return result;
        }
    }

    @Test
    public void testProxy1() throws Exception {
        CalculatorImpl calculatorImpl = new CalculatorImpl();
        Calculator proxy = (Calculator) getProxy(calculatorImpl);
        int sum = proxy.add(1, 2);
        System.out.println(sum);
    }

    public static Object getProxy(final Object object) throws Exception {
        Class proxyClazz = Proxy.getProxyClass(object.getClass().getClassLoader(), object.getClass().getInterfaces());
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance(new InvocationHandlerImpl(object));
        return proxy;
    }


    public static Object getProxy0(final Object object) throws Exception {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandlerImpl(object));
    }

    public static void printClassInfo(Executable[] targets) {
        for (Executable target : targets) {
            // 构造器/方法名称
            String name = target.getName();
            StringBuilder sBuilder = new StringBuilder(name);
            // 拼接左括号
            sBuilder.append('(');
            Class[] clazzParams = target.getParameterTypes();
            // 拼接参数
            for (Class clazzParam : clazzParams) {
                sBuilder.append(clazzParam.getName()).append(',');
            }
            //删除最后一个参数的逗号
            if (clazzParams != null && clazzParams.length != 0) {
                sBuilder.deleteCharAt(sBuilder.length() - 1);
            }
            //拼接右括号
            sBuilder.append(')');
            //打印 构造器/方法
            System.out.println(sBuilder.toString());
        }
    }
}
