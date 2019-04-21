package com.chenguangli.annotation;

import java.lang.reflect.Field;

/**
 * @author chenguangli
 * @date 2019/4/21 21:10
 */
public class TestGetAnnotation {
    public static void main(String[] args) throws Exception{
        //获取类上的注解
        Class<TestClass> clazz  = TestClass.class;
        TestAnnotation annotation = clazz.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.stringValue());

        //字段上
        Field field = clazz.getDeclaredField("name1");
        TestAnnotation2 annotation2 = field.getAnnotation(TestAnnotation2.class);
        System.out.println(annotation2.value());
    }
}
