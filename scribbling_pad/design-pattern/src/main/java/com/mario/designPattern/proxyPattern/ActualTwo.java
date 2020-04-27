package com.mario.designPattern.proxyPattern;

/**
 * Created by Mario on 2016/4/29.
 */
public class ActualTwo implements  ProxyInter {
    @Override
    public void sayHello() {
        System.out.println("ActualTwo says hello...");
    }
}
