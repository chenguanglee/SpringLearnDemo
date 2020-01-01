package com.chenguangli.advance.pattern.statespring;

/**
 * @author chenguangli
 * @date 2019/5/26 20:27
 */
public abstract class State {

    protected Machine machine;

    public State(Machine machine) {
        this.machine = machine;
    }

    public abstract void insertCoin();

    public abstract void ejectCoin();

    public abstract void turnCrank();

    public abstract void dispense();
}
