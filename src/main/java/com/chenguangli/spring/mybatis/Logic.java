package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author chenguangli
 * @date 2021/1/24 10:17
 */
@Component
public class Logic {


    @Autowired
    private SpitterDao spitterDao;


    public void testTransactional() {
        testTransactional1();
    }


    @Transactional(rollbackFor = Exception.class)
    public void testTransactional1() {
        Spitter spitter = new Spitter();
        spitter.setId(16);
        spitter.setUserName("胡歌");
        spitter.setPassword("hu123");
        spitter.setFullName("huge");
        spitter.setEmail("hu@qq.com");
        spitter.setCreateTime(new Date());
        spitter.setModifyTime(new Date());
        int effect0 = spitterDao.insertRow0(spitter);

        int a = 10/0;

        spitter = new Spitter();
        spitter.setId(17);
        spitter.setUserName("林俊杰");
        spitter.setPassword("jj");
        spitter.setFullName("jj");
        spitter.setEmail("jj@qq.com");
        spitter.setCreateTime(new Date());
        spitter.setModifyTime(new Date());
        spitterDao.insertRow0(spitter);
    }
}
