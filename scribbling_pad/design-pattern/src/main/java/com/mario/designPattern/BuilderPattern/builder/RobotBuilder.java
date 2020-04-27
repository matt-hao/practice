package com.mario.designPattern.BuilderPattern.builder;

import com.mario.designPattern.BuilderPattern.RobotModel;

import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 */
public abstract class RobotBuilder {

    public abstract RobotModel getRobotModel();

    public abstract void setSequence(List<String> sequence);
}
