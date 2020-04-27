package com.shiro.source.study.domain;

/**
 * Created by Mario on 2016/7/6.
 */
public class Permission {
    /**
     * id
     */
    private Long id;
    /**
     * 权限代码
     */
    private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
