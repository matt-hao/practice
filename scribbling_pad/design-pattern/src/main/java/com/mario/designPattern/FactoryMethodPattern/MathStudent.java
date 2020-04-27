package com.mario.designPattern.FactoryMethodPattern;

/**
 * Created by Mario on 2016/5/23.
 */
public class MathStudent implements Student {
    @Override
    public void goodAt() {
        System.out.println("math");
    }
}
