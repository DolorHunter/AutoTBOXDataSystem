package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class RoleEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '角色名'")
    private String roleName;
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '角色类型'")
    private String roleType;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '父角色ID'")
    private Integer fatherRoleId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getFatherRoleId() {
        return fatherRoleId;
    }

    public void setFatherRoleId(Integer fatherRoleId) {
        this.fatherRoleId = fatherRoleId;
    }
}
