package com.mario.designPattern.AdapterPattern;

/**
 * Created by Mario on 2016/6/1.
 *
 * @remark 适配器模式:将扩展应用集成到已有系统中,由于扩展应用数据结构在很大几率上与已有应用的数据结构不同，
 * 这样就需要在两个应用之间加入一个适配器。将扩展应用的数据结构转化为已有系统的数据结构
 */
public class Main {
    public static void main(String[] args) {
        IUserInfo userInfo = new OuterInfoWrapper();
        userInfo.getJobPosition();
        userInfo.getOfficeNumber();
        userInfo.getUserAddress();
        userInfo.getUserMobile();
        userInfo.getUserName();
    }
}
