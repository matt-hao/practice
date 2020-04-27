package com.mario.designPattern.AdapterPattern;

/**
 * Created by Mario on 2016/6/1.
 */
public interface IUserInfo {
    /**
     * basicInfo:姓名
     *
     * @return
     */
    String getUserName();

    /**
     * basicInfo:手机号
     *
     * @return
     */
    String getUserMobile();

    /**
     * homeInfo:用户地址
     *
     * @return
     */
    String getUserAddress();

    /**
     * officeInfo:办公室号码
     *
     * @return
     */
    String getOfficeNumber();

    /**
     * officeInfo:职位
     *
     * @return
     */
    String getJobPosition();
}
