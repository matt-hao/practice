package com.mario.designPattern.TemplateMethodPattern.interf;

/**
 * Created by Mario on 2016/6/1.
 * @remark 模板模式
 */
public class Main {
    public static void main(String[] args) {
        RobotOne robotModeOne  = new RobotOne();
        robotModeOne.function();


        RobotTwo robotModelTwo  = new RobotTwo();
        robotModelTwo.setCanFly(true);
        robotModelTwo.function();
    }
}
