package com.mario.designPattern.AdapterPattern;

/**
 * Created by Mario on 2016/6/1.
 */
public class OuterInfoWrapper extends OuterInfo implements IUserInfo {

    @Override
    public String getUserName() {
        String userName = super.getUserBaseInfo().get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getUserMobile() {
        String userMobile = super.getUserBaseInfo().get("userMobile");
        System.out.println(userMobile);
        return userMobile;
    }

    @Override
    public String getUserAddress() {
        String userAddress = super.getUserHomeInfo().get("userAddress");
        System.out.println(userAddress);
        return userAddress;
    }

    @Override
    public String getOfficeNumber() {
        String officeNumber = super.getUserOfficeInfo().get("officeNumber");
        System.out.println(officeNumber);
        return officeNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = super.getUserOfficeInfo().get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }
}
