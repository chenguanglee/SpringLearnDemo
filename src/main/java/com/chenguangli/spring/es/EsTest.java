package com.chenguangli.spring.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenguangli
 * @date 2019/5/27 23:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EsConfiguration.class)
public class EsTest {

    @Autowired
    private EsService esService;

    @Test
    public void test1() {
        esService.query(String.valueOf(1));
    }
}
