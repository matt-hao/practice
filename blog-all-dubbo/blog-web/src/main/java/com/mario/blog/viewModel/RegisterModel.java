package com.mario.blog.viewModel;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Mario on 2015/9/17.
 */

public class RegisterModel {

    @Size(min = 1, max = 10, message = "输入姓名在1~10个字符之间")
    @NotBlank(message = "输入姓名不能为空")
    @NotNull(message = "不能为空")
    private String name;

    @NotBlank(message = "输入email不能为空")
    @Pattern(regexp = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$", message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "输入密码不能为空")
    @Size(min = 6, max = 30, message = "密码长度在6~30个字符之间")
    private String password;

    @NotBlank(message = "确认密码不能为空")
    @Size(min = 6, max = 30, message = "确认密码长度在6~30个字符之间")
    private String comfirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }
}
