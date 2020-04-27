package com.mario.designPattern.AdapterPattern;

/**
 * Created by Mario on 2016/6/1.
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("这是姓名");
        return null;
    }

    @Override
    public String getUserMobile() {
        System.out.println("这是电话号码");
        return null;
    }

    @Override
    public String getUserAddress() {
        System.out.println("这是用户地址");
        return null;
    }

    @Override
    public String getOfficeNumber() {
        System.out.println("这是办公室号码");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("这是职位信息");
        return null;
    }
}
