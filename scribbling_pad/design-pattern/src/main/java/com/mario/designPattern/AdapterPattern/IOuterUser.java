package com.mario.designPattern.AdapterPattern;

import java.util.Map;

/**
 * Created by Mario on 2016/6/1.
 */
public interface IOuterUser {
    Map<String, String> getUserBaseInfo();

    Map<String, String> getUserOfficeInfo();

    Map<String, String> getUserHomeInfo();
}
