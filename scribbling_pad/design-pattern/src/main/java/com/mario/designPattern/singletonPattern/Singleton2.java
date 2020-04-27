package com.mario.designPattern.singletonPattern;

/**
 * Created by mth on 5/4/2016.
 *
 * @Remark 懒汉模式:效率低,可以解决并发情况下同步问题
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
