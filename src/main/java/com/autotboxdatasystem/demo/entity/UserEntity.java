package com.autotboxdatasystem.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "VARCHAR(32) comment '用户名'")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, columnDefinition = "VARCHAR(64) comment '密码'")
    private String password;
    @Column(columnDefinition = "VARCHAR(32) comment '邮箱'")
    private String email;
    @Column(columnDefinition = "VARCHAR(16) comment '电话'")
    private String phone;
    @Column(columnDefinition = "VARCHAR(64) comment '头像'")
    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
