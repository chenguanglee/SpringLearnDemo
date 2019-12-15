package com.chenguangli.pattern.stausmachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenguangli
 * @date 2019/11/2 21:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StatusConfig.class})
public class MyApp {


    @Autowired
    StateMachine<States, Events> stateMachine;


    @Test
    public void doSignal() {
        stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
    }
}
