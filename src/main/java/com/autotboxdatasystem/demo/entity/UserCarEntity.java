package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserCarEntity extends BaseEntity{
    @Column(nullable = false, columnDefinition = "int comment '用户ID'")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "VARCHAR(32) comment '用户名'")
    private String username;
    @Column(nullable = false, columnDefinition = "int comment '车辆ID'")
    private Integer carId;
    @Column(nullable = false, columnDefinition = "VARCHAR(255) comment '车辆名'")
    private String carName;

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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
