package com.example.demo.Config;


import com.example.demo.Events.OrderEvent;
import com.example.demo.Model.Order;
import com.example.demo.States.OrderStatus;

import com.example.demo.States.OrderStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;


@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderEvent> states) throws Exception {
        states
                .withStates()
                .initial(OrderStatus.ORDER_PLACED)  // Initial state
                .state(OrderStatus.SHIPPED)         // Next state
                .state(OrderStatus.DELIVERED);      // Final state
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderEvent> transitions) throws Exception {
        transitions
                .withExternal().source(OrderStatus.ORDER_PLACED).target(OrderStatus.SHIPPED).event(OrderEvent.SHIP_ORDER)
                .and()
                .withExternal().source(OrderStatus.SHIPPED).target(OrderStatus.DELIVERED).event(OrderEvent.DELIVER_ORDER);
    }
}

//@Configuration
//@EnableStateMachine
//public class StateMachineConfig
//        extends EnumStateMachineConfigurerAdapter<States, Events> {
//
//    @Override
//    public void configure(StateMachineStateConfigurer<States, Events> states)
//            throws Exception {
//        states
//                .withStates()
//                .initial(States.SI)
//                .states(EnumSet.allOf(States.class));
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
//            throws Exception {
//        transitions
//                .withExternal()
//                .source(States.SI)
//                .target(States.S1)
//                .event(Events.E1)
//                .and()
//                .withExternal()
//                .source(States.S1)
//                .target(States.S2)
//                .event(Events.E2);
//    }
//
//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
//            throws Exception {
//        config
//                .withConfiguration()
//                .autoStartup(true)
//                .listener(listener());
//    }
//
//    @Override
//    public void configure(StateMachineStateConfigurer<States, Events> states)
//            throws Exception {
//        states
//                .withStates()
//                .initial(States.SI)
//                .states(EnumSet.allOf(States.class));
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
//            throws Exception {
//        transitions
//                .withExternal()
//                .source(States.SI).target(States.S1).event(Events.E1)
//                .and()
//                .withExternal()
//                .source(States.S1).target(States.S2).event(Events.E2);
//    }
//
//    @Bean
//    public StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//            @Override
//            public void stateChanged(State<States, Events> from, State<States, Events> to) {
//                System.out.println("State change to " + to.getId());
//            }
//        };
//    }
//}