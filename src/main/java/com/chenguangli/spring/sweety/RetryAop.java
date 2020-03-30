package com.chenguangli.spring.sweety;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author chenguangli
 * @date 2020/3/24 22:16
 */
@Aspect
@Component
public class RetryAop {

    @Pointcut("@annotation(com.chenguangli.spring.sweety.RetryIfThrowable)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        RetryIfThrowable annotation = method.getAnnotation(RetryIfThrowable.class);
        int times = annotation.times();
        long waitTime = annotation.waitTimeMillis();
        Class<?> expClass = annotation.expClass();
        for (int i = 0; i < times; i++) {
            try {
                proceedingJoinPoint.proceed();
                return;
            } catch (Throwable e) {
                //判断捕获的异常是否是注解上指定异常的子类或本身
                if (expClass.isAssignableFrom(e.getClass())) {
                    System.out.println("出现异常,进行重试");
                    try {
                        Thread.sleep(waitTime);
                    } catch (InterruptedException e1) {

                    }
                } else {
                    System.out.println("非指定异常, 退出!");
                    return;
                }
            }
        }
    }
}
