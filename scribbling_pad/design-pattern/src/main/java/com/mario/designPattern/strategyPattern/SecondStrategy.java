package com.mario.designPattern.strategyPattern;

/**
 * Created by Mario on 2016/4/29.
 */
public class SecondStrategy  implements Strategy{
    @Override
    public void sayHello() {
        System.out.println("second strategy says hello...");
    }
}
