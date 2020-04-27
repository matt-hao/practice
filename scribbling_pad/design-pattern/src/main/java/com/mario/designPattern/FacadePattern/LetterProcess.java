package com.mario.designPattern.FacadePattern;

/**
 * Created by Mario on 2016/5/23.
 */
public interface LetterProcess {

    void writeContext(String context);

    void addressLetter(String address);

    void packageLetter();

    void sendLetter();
}
