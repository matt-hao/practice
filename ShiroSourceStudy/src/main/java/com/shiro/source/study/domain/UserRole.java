package com.shiro.source.study.domain;

/**
 * Created by mth on 2016/8/24.
 */
public class UserRole {
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 账号id
     */
    private Long rowId;
    /**
     * 账号类型
     */
    private String rowTable;

    public UserRole(User user, Long roleId) {
        this(user.getEntityKey(), roleId);
    }

    public UserRole(EntityKey entityKey, Long roleId) {
        this(roleId, entityKey.getRowId(), entityKey.getRowTable());
    }

    public UserRole(Long roleId, Long rowId, String rowTable) {
        this.roleId = roleId;
        this.rowId = rowId;
        this.rowTable = rowTable;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", rowId=" + rowId +
                ", rowTable='" + rowTable + '\'' +
                '}';
    }
}
