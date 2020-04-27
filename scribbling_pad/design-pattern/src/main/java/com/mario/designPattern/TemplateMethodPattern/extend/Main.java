package com.mario.designPattern.TemplateMethodPattern.extend;

/**
 * Created by Mario on 2016/6/1.
 * @remark 模板模式
 */
public class Main {
    public static void main(String[] args) {
        RobotOne robotOne = new RobotOne();
        robotOne.setCanFly(true);
        robotOne.run();
    }
}
