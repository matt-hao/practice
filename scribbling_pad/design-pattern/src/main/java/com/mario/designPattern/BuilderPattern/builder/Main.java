package com.mario.designPattern.BuilderPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 * @Remark 建造者模式
 */
public class Main {
    public static void main(String[] args) {

        List<String> sequence = new ArrayList<String>() {{
            add("talk");
            add("fly");
            add("walk");
        }};

        RobotBuilder robotBuilder = new RobotOneBuilder();
        robotBuilder.setSequence(sequence);
        robotBuilder.getRobotModel().run();
    }
}
