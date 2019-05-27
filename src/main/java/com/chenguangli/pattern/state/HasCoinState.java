package com.chenguangli.pattern.state;

/**
 * @author chenguangli
 * @date 2019/5/26 20:32
 */
public class HasCoinState extends State {


    public HasCoinState(Machine machine) {
        super(machine);
    }

    @Override
    public void insertCoin() {
        System.out.println("you can not insert another coin!");
    }

    @Override
    public void ejectCoin() {
        System.out.println("return coin!");
        machine.setState(machine.getNoCoinState());
    }

    @Override
    public void turnCrank() {
        System.out.println("your sweet is coming");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("no sweet");
    }
}
