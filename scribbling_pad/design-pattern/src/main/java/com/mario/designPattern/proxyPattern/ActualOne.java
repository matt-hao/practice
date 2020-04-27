package com.mario.designPattern.proxyPattern;

/**
 * Created by Mario on 2016/4/29.
 */
public class ActualOne implements ProxyInter{

    @Override
    public void sayHello() {
        System.out.println("ActualOne says hello...");
    }
}
