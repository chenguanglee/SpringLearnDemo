package com.chenguangli.spring.sweety;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SweetyConfig.class)
public class SweetyTest {


    @Autowired
    private LoveDessert loveDessert;


    @Test
    public void testSweety() {
        loveDessert.taste();
    }
}
