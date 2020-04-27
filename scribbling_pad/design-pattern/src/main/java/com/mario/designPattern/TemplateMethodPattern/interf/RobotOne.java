package com.mario.designPattern.TemplateMethodPattern.interf;

/**
 * Created by Mario on 2016/6/1.
 */
public class RobotOne implements RobotModel {

    private boolean isCanFly = false;

    @Override
    public void walk() {
        System.out.println("RobotOne can walk");
    }

    @Override
    public void talk() {
        System.out.println("RobotOne can talk");
    }

    @Override
    public void fly() {
        System.out.println("RobotOne can fly");
    }

    @Override
    public boolean isCanFly() {
        return this.isCanFly;
    }

    public void setCanFly(boolean canFly) {
        isCanFly = canFly;
    }

}
