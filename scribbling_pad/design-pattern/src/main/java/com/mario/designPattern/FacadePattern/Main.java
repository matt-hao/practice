package com.mario.designPattern.FacadePattern;

/**
 * Created by Mario on 2016/5/23.
 *
 * @Remark 门面模式
 */
public class Main {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice("内容就是...", "地址就是...", new LetterProcessImpl());
        postOffice.sendLetter();
    }
}
