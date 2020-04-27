package com.mario.designPattern.BuilderPattern.director;


import com.mario.designPattern.BuilderPattern.RobotModel;
import com.mario.designPattern.BuilderPattern.builder.RobotBuilder;
import com.mario.designPattern.BuilderPattern.builder.RobotOneBuilder;
import com.mario.designPattern.BuilderPattern.builder.RobotTwoBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 */
public class RobotDirector {
    private static final List<String> sequence = new ArrayList<>();

    public RobotModel getRobotOne_AModel() {
        synchronized (sequence) {
            sequence.clear();
            sequence.add("fly");
            sequence.add("talk");
            sequence.add("walk");
            RobotBuilder robotBuilder = new RobotOneBuilder();
            robotBuilder.setSequence(sequence);
            return robotBuilder.getRobotModel();
        }
    }

    public RobotModel getRobotOne_BModel() {
        synchronized (sequence) {
            sequence.clear();
            sequence.add("talk");
            sequence.add("fly");
            sequence.add("walk");
            RobotBuilder robotBuilder = new RobotOneBuilder();
            robotBuilder.setSequence(sequence);
            return robotBuilder.getRobotModel();
        }
    }

    public RobotModel getRobotTwo_AModel() {
        synchronized (sequence) {
            sequence.clear();
            sequence.add("fly");
            sequence.add("talk");
            sequence.add("walk");
            RobotBuilder robotBuilder = new RobotTwoBuilder();
            robotBuilder.setSequence(sequence);
            return robotBuilder.getRobotModel();
        }
    }

    public RobotModel getRobotTwo_BModel() {
        synchronized (sequence) {
            sequence.clear();
            sequence.add("talk");
            sequence.add("fly");
            sequence.add("walk");
            RobotBuilder robotBuilder = new RobotTwoBuilder();
            robotBuilder.setSequence(sequence);
            return robotBuilder.getRobotModel();
        }
    }
}
