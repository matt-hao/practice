package com.mario.designPattern.BuilderPattern.builder;

import com.mario.designPattern.BuilderPattern.RobotModel;
import com.mario.designPattern.BuilderPattern.RobotOne;

import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 */
public class RobotOneBuilder extends RobotBuilder {

    private RobotOne robotOne = new RobotOne();

    @Override
    public RobotModel getRobotModel() {
        return this.robotOne;
    }

    @Override
    public void setSequence(List<String> sequence) {
        this.robotOne.setSequence(sequence);
    }
}
