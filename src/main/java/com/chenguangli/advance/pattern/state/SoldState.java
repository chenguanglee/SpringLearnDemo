package com.chenguangli.advance.pattern.state;

/**
 * @author chenguangli
 * @date 2019/5/26 20:33
 */
public class SoldState extends State {

    public SoldState(Machine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {
        System.out.println("wrong state");
    }

    @Override
    public void ejectCoin() {
        System.out.println("sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("you can not turn twice crank");
    }

    @Override
    public void dispense() {
        System.out.println("sweet is coming");
        machine.releaseBall();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoCoinState());
        } else {
            machine.setState(machine.getSoldOutState());
        }
    }
}
