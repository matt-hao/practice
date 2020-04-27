package com.mario.designPattern.BuilderPattern.director;

/**
 * Created by Mario on 2016/6/3.
 * @Remark 建造者模式
 */
public class Main {
    public static void main(String[] args) {
        RobotDirector robotDirector = new RobotDirector();
        robotDirector.getRobotOne_AModel().run();
        robotDirector.getRobotOne_BModel().run();
        robotDirector.getRobotTwo_AModel().run();
        robotDirector.getRobotTwo_BModel().run();
    }
}
