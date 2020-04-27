package com.mario.designPattern.BuilderPattern;

/**
 * Created by Mario on 2016/6/3.
 */
public class RobotTwo extends RobotModel {

    @Override
    protected void walk() {
        System.out.println("robot two walk...");
    }

    @Override
    protected void talk() {
        System.out.println("robot two talk...");
    }

    @Override
    protected void fly() {
        System.out.println("robot two fly...");
    }
}
