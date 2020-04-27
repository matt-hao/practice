package com.mario.designPattern.singletonPattern;

/**
 * Created by mth on 5/4/2016.
 * @Remark 懒汉模式:内部类方式
 */
public class Singleton4 {
    private static class Singleton4Holder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public Singleton4 getInstance() {
        return Singleton4Holder.INSTANCE;
    }

}
