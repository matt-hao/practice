package com.mario.designPattern.BuilderPattern;

/**
 * Created by Mario on 2016/6/3.
 */
public class RobotOne extends RobotModel {
    @Override
    protected void walk() {
        System.out.println("robot one walk...");
    }

    @Override
    protected void talk() {
        System.out.println("robot one talk...");
    }

    @Override
    protected void fly() {
        System.out.println("robot one fly...");
    }
}
