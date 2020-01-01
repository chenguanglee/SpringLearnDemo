package com.chenguangli.base.annotation;

import java.lang.annotation.*;

/**
 * @author chenguangli
 * @date 2019/4/21 20:55
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
public @interface TestAnnotation {
    //注解中支持的数据类型
    //支持8种基本数据类型
    int intValue();

    long longValue();

    //...

    //String
    String stringValue();

    //枚举
    TestEnum enumValue();

    //Class
    Class clazz();

    //注解
    TestAnnotation2 annotationValue();

    //上述类型对应的一维数组
    int[] intArrayValue();

    String[] stringArrayValue();

    //....
}
