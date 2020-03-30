package com.chenguangli.spring.sweety;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SweetyConfig.class)
public class SweetyTest {


    @Autowired
    private LoveDessert loveDessert;
    @Autowired
    private RetryTest retryTest;


    @Test
    public void testSweety() {
        loveDessert.taste();
    }

    @Test()
    public void testRetry() {
        retryTest.method();
        System.out.println("test over");
    }
}
