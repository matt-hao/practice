package com.mario.designPattern.TemplateMethodPattern.interf;

/**
 * Created by Mario on 2016/6/1.
 */
public interface RobotModel {
    void walk();

    void talk();

    void fly();

    boolean isCanFly();

    default void function() {
        this.walk();
        this.talk();
        if (isCanFly())
            this.fly();
    }
}
