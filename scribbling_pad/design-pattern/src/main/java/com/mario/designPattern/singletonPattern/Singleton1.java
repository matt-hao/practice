package com.mario.designPattern.singletonPattern;

/**
 * Created by mth on 5/4/2016.
 *
 * @Remark 懒汉模式:严格意义上这种写法有问题,当a、b线程同时访问,会出现多实例的情况
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        //当a、b同时执行到此处,有一定几率会生成两个实例
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
