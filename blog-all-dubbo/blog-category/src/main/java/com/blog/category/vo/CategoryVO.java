package com.blog.category.vo;

import java.sql.Timestamp;

/**
 * Created by Mario on 2015/9/9.
 */
public class CategoryVO {
    private String uuid;
    private String name;
    private Timestamp createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
