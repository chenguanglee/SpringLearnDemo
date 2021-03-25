package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

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

    @Autowired
    private Logic logic;

    @Test
    public void testQuery() {
        int id = 3;
        Spitter spitter = spitterDao.getSpitter(id);
        log.info("返回结果spitter={}", spitter);
        spitter = spitterDao.getSpitter0(id);
        log.info("第二次返回结果spitter={}", spitter);
        System.out.println(spitter);
    }

    @Test
    public void testUpdate() {
        spitterDao.updateSpitter("12334335@qq.com", "sun");
    }

    @Test
    public void test1() {
        System.out.println(spitterDao.getUserName(1));
    }

    @Test
    public void test2() {
        Spitter spitter = new Spitter();
        spitter.setEmail("lee@qq.com");
        spitter.setPassword("456");
        //spitter.setUserName("sun");
        spitterDao.updateSpitter0(spitter);
    }

    @Test
    public void testInsert() {
        Spitter spitter = new Spitter();
        spitter.setId(14);
        spitter.setUserName("jay");
        spitter.setPassword("jay123");
        spitter.setFullName("林俊杰");
        spitter.setEmail("jay@qq.com");
        spitter.setCreateTime(new Date());
        spitter.setModifyTime(new Date());
        int effectRows = spitterDao.insertRow(spitter);
        System.out.println("effectRows=" + effectRows);
        System.out.println("id=" + spitter.getId());
        System.out.println(spitter);
        System.out.println("--------------------");

    }

    @Test
    public void testInsert1() {
        Spitter spitter = new Spitter();
        spitter.setId(14);
        spitter.setUserName("胡歌");
        spitter.setPassword("hu123");
        spitter.setFullName("huge");
        spitter.setEmail("hu@qq.com");
        spitter.setCreateTime(new Date());
        spitter.setModifyTime(new Date());
        int effect0 = spitterDao.insertRow0(spitter);
        System.out.println("effect0=" + effect0);
        System.out.println("id=" + spitter.getId());
        System.out.println(spitter);
    }

    @Test
    public void testDelete() {
        int id = 24;
        int effectRow = spitterDao.deleteRow(id);
        System.out.println(effectRow);
    }

    @Test
    public void testSelectProvider() {
        System.out.println(spitterDao.selectById(2));
    }


    @Test
    public void testTransactional() {
        logic.testTransactional();
    }
}
