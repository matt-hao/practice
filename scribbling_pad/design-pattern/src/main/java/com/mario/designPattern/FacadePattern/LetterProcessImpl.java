package com.mario.designPattern.FacadePattern;

/**
 * Created by Mario on 2016/5/23.
 */
public class LetterProcessImpl implements LetterProcess {

    @Override
    public void writeContext(String context) {
        System.out.println("信件内容:" + context);
    }

    @Override
    public void addressLetter(String address) {
        System.out.println("信件地址:" + address);
    }

    @Override
    public void packageLetter() {
        System.out.println("封装信封");
    }

    @Override
    public void sendLetter() {
        System.out.println("邮寄信");
    }
}
