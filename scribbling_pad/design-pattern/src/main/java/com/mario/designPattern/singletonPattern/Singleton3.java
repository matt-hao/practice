package com.mario.designPattern.singletonPattern;

/**
 * Created by mth on 5/4/2016.
 *
 * @Remark 饿汉模式
 */
public class Singleton3 {
    private static Singleton3 singleton3 = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return singleton3;
    }

    //    private static Singleton3 singleton3;
    //    static {
    //        singleton3 = new Singleton3();
    //    }
    //     public static Singleton3 getInstance() {
    //    return singleton3;
    //}
}