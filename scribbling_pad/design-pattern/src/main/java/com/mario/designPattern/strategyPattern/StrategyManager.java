package com.mario.designPattern.strategyPattern;

/**
 * Created by Mario on 2016/4/29.
 */
public class StrategyManager {

    private Strategy strategy;

    public StrategyManager(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sayHello() {
        this.strategy.sayHello();
    }
}
