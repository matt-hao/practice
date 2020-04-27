package com.shiro.source.study.domain;

/**
 * Created by Mario on 2016/9/7.
 */
public class EntityKey {
    private Long rowId;
    private String rowTable;

    public EntityKey(Long rowId, String rowTable) {
        this.rowId = rowId;
        this.rowTable = rowTable;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getRowTable() {
        return rowTable;
    }

    public void setRowTable(String rowTable) {
        this.rowTable = rowTable;
    }
}
