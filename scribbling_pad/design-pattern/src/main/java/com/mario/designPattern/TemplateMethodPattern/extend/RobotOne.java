package com.mario.designPattern.TemplateMethodPattern.extend;

/**
 * Created by Mario on 2016/6/1.
 */
public class RobotOne extends RobotModel {

    private boolean canFly = false;

    @Override
    protected void walk() {
        System.out.println("RobotOne can walk");
    }

    @Override
    protected void talk() {
        System.out.println("RobotOne can talk");
    }

    @Override
    protected void fly() {
        System.out.println("RobotOne can fly");
    }

    @Override
    protected boolean isCanFly() {
        return this.canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}
