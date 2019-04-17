package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MybatisTest {


    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void testQuery() {
        int id = 3;
        Spitter spitter = spitterDao.getSpitter(id);
        log.info("返回结果spitter={}", spitter);
        spitter = spitterDao.getSpitter0(id);
        log.info("第二次返回结果spitter={}", spitter);
        System.out.println(spitter);
    }
}
