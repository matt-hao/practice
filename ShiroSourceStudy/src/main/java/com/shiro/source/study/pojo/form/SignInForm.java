package com.shiro.source.study.pojo.form;

import com.shiro.source.study.domain.User;

/**
 * Created by Mario on 2016/7/13.
 */
public class SignInForm {
    private String userName;
    private String password;

    private String host;

    public SignInForm() {
    }

    public SignInForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        if (!(host == null || host.isEmpty())) {
            User.HOST.valueOf(host);
        }
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
