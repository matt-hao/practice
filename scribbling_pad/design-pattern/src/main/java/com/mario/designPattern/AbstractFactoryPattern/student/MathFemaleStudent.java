package com.mario.designPattern.AbstractFactoryPattern.student;

/**
 * Created by Mario on 2016/5/23.
 */
public class MathFemaleStudent extends AbstractMathStudent {

    @Override
    public void sex() {
        System.out.println("math female");
    }
}
