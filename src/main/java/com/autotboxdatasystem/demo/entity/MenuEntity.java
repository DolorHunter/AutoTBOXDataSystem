package com.autotboxdatasystem.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MenuEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '菜单名'")
    private String menuName;
    @Column(nullable = false, columnDefinition = "VARCHAR(20) comment '菜单类型'")
    private String menuType;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '父菜单ID'")
    private Integer fatherMenuId;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Integer getFatherMenuId() {
        return fatherMenuId;
    }

    public void setFatherMenuId(Integer fatherMenuId) {
        this.fatherMenuId = fatherMenuId;
    }
}
