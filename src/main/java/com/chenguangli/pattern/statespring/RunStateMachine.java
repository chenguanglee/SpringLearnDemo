package com.chenguangli.pattern.statespring;

import org.junit.Test;

/**
 * @author chenguangli
 * @date 2019/11/2 23:52
 */
public class RunStateMachine {


    @Test
    public void test1() {
        Machine machine = new Machine();
        machine.insertCoin();
        machine.turnCrank();
        machine.turnCrank();
        machine.turnCrank();
    }
}
