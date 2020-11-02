package com.chenguangli.spring.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DbConfig.class)
@ActiveProfiles("jdbc")
public class DbTest {

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void testInsert() {
        Spitter spitter = new Spitter();
        spitter.setUserName("李晨光");
        spitter.setPassword("123123");
        spitter.setFullName("administrator");
        spitter.setEmail("admin@qq.com");
        spitter.setCreateTime(new Date());
        spitter.setModifyTime(new Date());
        spitterRepository.addSpitter(spitter);
    }

    @Test
    public void testSelect() {
        int id = 4;
        Spitter spitter = spitterRepository.findOne(id);
        System.out.println(spitter);
    }


    @Test
    public void testInsert1() {
        spitterRepository.addSkuInfo("1","1");
    }

    @Test
    public void testInsert2() {
        spitterRepository.addRelation();
    }
}
