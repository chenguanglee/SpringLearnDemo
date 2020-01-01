package com.chenguangli.advance.pattern.stausmachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author chenguangli
 * @date 2019/11/2 21:48
 */
@Configuration
@EnableStateMachine
public class StatusConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {

        states.withStates().initial(States.STATE1).states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions.withExternal().source(States.STATE1).target(States.STATE2).event(Events.EVENT1).action(action1()).and()
                .withExternal().source(States.STATE2).target(States.STATE1).event(Events.EVENT2).action(action2());

    }


    public Action<States, Events> action1() {
        return context -> System.out.println("action1");
    }

    public Action<States, Events> action2() {
        return context -> System.out.println("action2");
    }

    public Action<States, Events> action3() {
        return new Action<States, Events>() {
            @Override
            public void execute(StateContext<States, Events> stateContext) {
                System.out.println(123);
            }
        };
    }
}
