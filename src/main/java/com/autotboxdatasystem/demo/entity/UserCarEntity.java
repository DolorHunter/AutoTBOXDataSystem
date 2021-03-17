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
    @Column(nullable = false, columnDefinition = "varchar(64) comment '车辆识别号码'")
    private String vin;
    @Column(nullable = false, columnDefinition = "varchar(255) comment '4S店名'")
    private String _4SShop;
    @Column(nullable = false, columnDefinition = "varchar(64) comment '销售位置'")
    private String saleLoc;
    @Column(nullable = false, columnDefinition = "varchar(64) comment '销售时间'")
    private String saleTime;

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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String get_4SShop() {
        return _4SShop;
    }

    public void set_4SShop(String _4SShop) {
        this._4SShop = _4SShop;
    }

    public String getSaleLoc() {
        return saleLoc;
    }

    public void setSaleLoc(String saleLoc) {
        this.saleLoc = saleLoc;
    }

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }
}
