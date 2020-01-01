package com.chenguangli.advance.pattern.statespring;

import lombok.Getter;

/**
 * @author chenguangli
 * @date 2019/5/26 20:34
 */
@Getter

public class Machine {

    private State soldOutState;
    private State noCoinState;
    private State hasCoinState;
    private State soldState;

    private State state = soldOutState;


    public Machine() {

        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);

    }


    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }


    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("a ball sold");
    }

}
