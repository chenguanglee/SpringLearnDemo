package com.chenguangli.advance.pattern.state;

/**
 * @author chenguangli
 * @date 2019/5/26 20:31
 */
public class NoCoinState extends State {

    public NoCoinState(Machine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("ban action");
    }

    @Override
    public void turnCrank() {
        System.out.println("ban action");
    }

    @Override
    public void dispense() {
        System.out.println("ban action");
    }
}
