package com.chenguangli.spring.sweety;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenguangli
 * @date 2020/3/24 22:10
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RetryIfThrowable {

    /**
     * 异常重试次数
     *
     * @return
     */
    int times() default 1;

    /**
     * 重试间隔(ms)
     *
     * @return
     */
    long waitTimeMillis() default 0L;

    /**
     * 捕获指定的异常类型
     *
     * @return
     */
    Class<? extends Throwable> expClass() default Throwable.class;
}
