package com.chenguangli.advance.pattern.state;

/**
 * @author chenguangli
 * @date 2019/5/26 20:33
 */
public class SoldOutState extends State {

    public SoldOutState(Machine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {

    }

    @Override
    public void ejectCoin() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
