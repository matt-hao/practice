package com.shiro.source.study.domain;

import java.util.List;

/**
 * Created by mth on 2016/8/26.
 */
public class User {
    public enum HOST {
        TEACHER, STUDENT, ADMIN
    }

    /**
     * 主键id
     */
    protected Long id;
    /**
     * 姓名
     */
    protected String name;
    /**
     * 账号
     */
    protected String account;
    /**
     * 密码
     */
    protected String password;
    /**
     * 加盐
     */
    protected String salt;
    /**
     * 所拥有的角色
     */
    protected List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public EntityKey getEntityKey() {
        return new EntityKey(this.id, getClass().getSimpleName().toUpperCase());
    }
}
