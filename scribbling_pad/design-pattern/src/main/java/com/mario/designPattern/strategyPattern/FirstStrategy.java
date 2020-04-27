package com.mario.designPattern.strategyPattern;

/**
 * Created by Mario on 2016/4/29.
 */
public class FirstStrategy implements Strategy {
    @Override
    public void sayHello() {
        System.out.println("first strategy says hello...");
    }
}
