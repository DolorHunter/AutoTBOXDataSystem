package com.autotboxdatasystem.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RoleMenuEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "int comment '角色ID'")
    private Integer roleId;
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '角色名'")
    private String roleName;
    @Column(nullable = false, columnDefinition = "int comment '菜单ID'")
    private Integer menuId;
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '菜单名'")
    private String menuName;

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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
