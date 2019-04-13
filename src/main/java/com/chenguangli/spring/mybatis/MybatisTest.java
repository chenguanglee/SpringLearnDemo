package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by chenguangli on 2019/4/13 23:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
@ActiveProfiles("jdbc")
public class MybatisTest {


    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void testQuery() {
        int id = 3;
        Spitter spitter = spitterDao.getSpitter(id);
        System.out.println(spitter);
    }
}
