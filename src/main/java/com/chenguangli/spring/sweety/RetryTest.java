package com.chenguangli.spring.sweety;

import org.springframework.stereotype.Component;

/**
 * @author chenguangli
 * @date 2020/3/24 22:13
 */
@Component
public class RetryTest {

    @RetryIfThrowable(times = 3, waitTimeMillis = 0L,expClass = ArithmeticException.class)
    public void method() {
        System.out.println("try");
        int c = 10 / 0;
    }
}
