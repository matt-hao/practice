package com.mario.designPattern.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2016/6/3.
 */
public abstract class RobotModel {

    private List<String> sequence = new ArrayList<>();

    protected abstract void walk();

    protected abstract void talk();

    protected abstract void fly();

    public void run() {
        if (!(this.sequence == null || this.sequence.isEmpty())) {
            this.sequence.stream().forEach(s -> {
                switch (s) {
                    case "walk":
                        this.walk();
                        break;
                    case "talk":
                        this.talk();
                        break;
                    case "fly":
                        this.fly();
                        break;
                    default:
                        break;
                }
            });
        }
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }


    public static void main(String[] args) {
        RobotModel r = new RobotModel() {
            @Override
            protected void walk() {

            }

            @Override
            protected void talk() {

            }

            @Override
            protected void fly() {

            }
        };
    }
}
