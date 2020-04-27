package com.mario.designPattern.AdapterPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2016/6/1.
 */
public class OuterInfo implements IOuterUser {

    @Override
    public Map<String, String> getUserBaseInfo() {
        HashMap<String, String> basicInfoMap = new HashMap<>();
        basicInfoMap.put("userName", "outer用户姓名");
        basicInfoMap.put("userMobile", "outer用户手机号");
        return basicInfoMap;
    }

    @Override
    public Map<String, String> getUserOfficeInfo() {
        HashMap<String, String> userOfficeInfo = new HashMap<>();
        userOfficeInfo.put("officeNumber", "outer用户办公室号码");
        userOfficeInfo.put("jobPosition", "outer用户职位");
        return userOfficeInfo;
    }

    @Override
    public Map<String, String> getUserHomeInfo() {
        HashMap<String, String> userHomeInfo = new HashMap<>();
        userHomeInfo.put("userAddress", "outer用户地址");
        return userHomeInfo;
    }
}
