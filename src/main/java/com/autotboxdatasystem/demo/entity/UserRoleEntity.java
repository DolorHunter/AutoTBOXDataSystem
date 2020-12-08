package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserRoleEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "int comment '用户ID'")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '用户名'")
    private String username;
    @Column(nullable = false, columnDefinition = "int comment '角色ID'")
    private Integer roleId;
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '角色名'")
    private String roleName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
