package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class CarWarningDetailEntity extends BaseEntity{
    @Column(columnDefinition =  "VARCHAR(64) comment '车辆型号(vin前六位)'")
    private String carType;
    @Column(columnDefinition =  "VARCHAR(64) comment '错误类型'")
    private String faultCategory;
    @Column(columnDefinition =  "VARCHAR(64) comment '错误内容'")
    private String errorContent;
    @Column(columnDefinition =  "VARCHAR(255) comment '错误详情'")
    private String errorDetail;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFaultCategory() {
        return faultCategory;
    }

    public void setFaultCategory(String faultCategory) {
        this.faultCategory = faultCategory;
    }

    public String getErrorContent() {
        return errorContent;
    }

    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
