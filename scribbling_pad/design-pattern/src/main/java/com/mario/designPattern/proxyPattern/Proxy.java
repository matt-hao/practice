package com.mario.designPattern.proxyPattern;

/**
 * Created by Mario on 2016/4/29.
 */
public class Proxy implements ProxyInter {

    private ProxyInter proxyInter;

    public Proxy(ProxyInter proxyInter) {
        this.proxyInter = proxyInter;
    }

    @Override
    public void sayHello() {
        this.proxyInter.sayHello();
    }
}
