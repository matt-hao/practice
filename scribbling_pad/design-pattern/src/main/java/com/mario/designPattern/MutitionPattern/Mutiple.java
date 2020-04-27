package com.mario.designPattern.MutitionPattern;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mario on 2016/5/10.
 *
 * @Remark 多例模式
 */
public class Mutiple {

    private String name;

    private static final Integer MaxNumberOfMutiple = 2;

    private static ArrayList<Mutiple> mutiples = new ArrayList<>(MaxNumberOfMutiple);

    private static Integer chooseWho = 0;

    static {
        for (int i = 0; i < MaxNumberOfMutiple; i++) {
            mutiples.add(new Mutiple("mutiple" + i));
        }
    }

    private Mutiple() {
    }

    private Mutiple(String details) {
        this.name = details;
    }

    public static Mutiple getInstance() {
        Random random = new Random();
        chooseWho = random.nextInt(MaxNumberOfMutiple);
        return mutiples.get(chooseWho);
    }

    public static Mutiple getInstance(Integer index) {
        if (index == null || index >= mutiples.size()) return null;
        return mutiples.get(index);
    }

    public String getName() {
        return name;
    }
}
