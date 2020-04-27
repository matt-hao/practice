package com.mario.designPattern.TemplateMethodPattern.interf;

/**
 * Created by Mario on 2016/6/1.
 */
public class RobotTwo implements RobotModel {

    private boolean isCanFly = false;

    @Override
    public void walk() {
        System.out.println("RobotTwo can walk");
    }

    @Override
    public void talk() {
        System.out.println("RobotTwo can talk");
    }

    @Override
    public void fly() {
        System.out.println("RobotTwp can fly");
    }

    @Override
    public boolean isCanFly() {
        return isCanFly;
    }

    public void setCanFly(boolean canFly) {
        isCanFly = canFly;
    }
}
