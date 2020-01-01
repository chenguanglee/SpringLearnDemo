package com.chenguangli.base.annotation;

import java.lang.annotation.*;

/**
 * @author chenguangli
 * @date 2019/4/21 21:01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TestAnnotation2 {
    String value();
}
