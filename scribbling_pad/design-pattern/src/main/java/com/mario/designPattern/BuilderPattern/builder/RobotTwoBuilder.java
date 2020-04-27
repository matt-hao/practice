package com.mario.designPattern.BuilderPattern.builder;

import com.mario.designPattern.BuilderPattern.RobotModel;
import com.mario.designPattern.BuilderPattern.RobotTwo;

import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 */
public class RobotTwoBuilder extends RobotBuilder {

    private RobotTwo robotTwo = new RobotTwo();

    @Override
    public RobotModel getRobotModel() {
        return this.robotTwo;
    }

    @Override
    public void setSequence(List<String> sequence) {
        this.robotTwo.setSequence(sequence);
    }
}
