package com.mario.designPattern.MutitionPattern;

/**
 * Created by Mario on 2016/5/10.
 */
public class Main {

    public static void main(String[] args) {
        //随机获取
        for (int i = 0; i < 5; i++) {
            Mutiple mutiple = Mutiple.getInstance();
            System.out.println(i + " 对应的是--->" + mutiple.getName());
        }
        //指定获取
        Mutiple mutiple0 = Mutiple.getInstance(0);
        System.out.println(mutiple0.getName());
        Mutiple mutiple1 = Mutiple.getInstance(1);
        System.out.println(mutiple1.getName());
        Mutiple mutipleNull = Mutiple.getInstance(2);
        if (mutipleNull == null) {
            System.out.println(mutipleNull);
        } else {
            System.out.println(mutipleNull.getName());
        }
    }
}
