package com.chenguangli.pattern.proxy;

/**
 * @author chenguangli
 * @date 2019/4/21 11:41
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
