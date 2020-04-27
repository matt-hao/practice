package com.mario.designPattern.proxyPattern;

/**
 * Created by Mario on 2016/4/29.
 *
 * @Remark 代理模式
 */
public class Main {
    public static void main(String[] args) {
        Proxy proxyOne = new Proxy(new ActualOne());
        proxyOne.sayHello();

        Proxy proxyTwo = new Proxy(new ActualTwo());
        proxyTwo.sayHello();
    }
}
