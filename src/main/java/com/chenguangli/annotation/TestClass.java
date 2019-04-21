package com.chenguangli.annotation;

/**
 * @author chenguangli
 * @date 2019/4/21 21:04
 */
@TestAnnotation(
        intValue = 1,
        longValue = 2,
        stringValue = "123",
        enumValue = TestEnum.TEST1,
        clazz = TestClass.class,
        annotationValue = @TestAnnotation2("123"),
        intArrayValue = {1, 2},
        stringArrayValue = {"123", "qwe"}
)
public class TestClass {

    @TestAnnotation2("123")
    private String name1;


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}
