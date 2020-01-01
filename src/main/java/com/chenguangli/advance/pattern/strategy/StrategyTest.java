package com.chenguangli.advance.pattern.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StrategyConfig.class)
public class StrategyTest {

    @Autowired
    private Student student;


    @Test
    public void testTrackCounter() {
        List<DemoInterface> list = student.getDemoInterface();
        list.forEach((tmp) -> System.out.println(tmp.getStr("!") + ","));
    }
}
