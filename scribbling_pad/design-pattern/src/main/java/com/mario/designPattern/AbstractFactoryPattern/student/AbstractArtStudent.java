package com.mario.designPattern.AbstractFactoryPattern.student;

/**
 * Created by Mario on 2016/5/23.
 */
public abstract class  AbstractArtStudent implements Student {
    @Override
    public void goodAt() {
        System.out.println("art");
    }
}
