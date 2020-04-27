package com.mario.designPattern.TemplateMethodPattern.extend;

/**
 * Created by Mario on 2016/6/1.
 */
public abstract class RobotModel {

    protected abstract void walk();

    protected abstract void talk();

    protected abstract void fly();

    protected abstract boolean isCanFly();

    public void run() {
        this.walk();
        this.talk();
        if (isCanFly())
            this.fly();
    }
}
