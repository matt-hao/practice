package com.mario.designPattern.strategyPattern;

/**
 * Created by Mario on 2016/4/29.
 *
 * @Remark 策略模式
 */
public class Main {
    public static void main(String[] args) {
        //first strategy
        StrategyManager strategyManagerFirst = new StrategyManager(new FirstStrategy());
        strategyManagerFirst.sayHello();

        //second strategy
        StrategyManager secondStrategyManager = new StrategyManager(new SecondStrategy());
        secondStrategyManager.sayHello();

    }
}
