package com.mario.designPattern.BuilderPattern.origin;

import com.mario.designPattern.BuilderPattern.RobotModel;
import com.mario.designPattern.BuilderPattern.RobotOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 *
 * @Remark 建造者模式
 */
public class Main {
    public static void main(String[] args) {

        List<String> sequence = new ArrayList<String>() {{
            add("fly");
            add("walk");
            add("talk");
        }};

        RobotModel robotModelOne = new RobotOne();
        robotModelOne.setSequence(sequence);
        robotModelOne.run();
    }
}
