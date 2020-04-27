package com.mario.designPattern.FacadePattern;

/**
 * Created by Mario on 2016/5/23.
 */
public class PostOffice {

    private String letterContext;

    private String letterAddress;

    private LetterProcess letterProcess;

    public PostOffice(String letterContext, String letterAddress, LetterProcess letterProcess) {
        this.letterContext = letterContext;
        this.letterAddress = letterAddress;
        this.letterProcess = letterProcess;
    }

    public void sendLetter() {
        //写信
        this.letterProcess.writeContext(this.letterContext);
        //地址
        this.letterProcess.addressLetter(this.letterAddress);
        //包装
        this.letterProcess.packageLetter();
        //邮寄
        this.letterProcess.sendLetter();
    }

}
