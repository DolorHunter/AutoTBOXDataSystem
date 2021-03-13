package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class CarWarningEntity extends BaseEntity{
    @Column(nullable = false, columnDefinition = "varchar(64) comment '车辆识别号码'")
    private String VIN;
    @Column(nullable = false, columnDefinition = "VARCHAR(255) comment '车辆名'")
    private String carName;
    @Column(columnDefinition = "VARCHAR(64) comment '故障代号'")
    private String warCode;
    @Column(columnDefinition = "VARCHAR(64) comment '故障标签'")
    private String warTags;
    @Column(columnDefinition = "VARCHAR(64) comment '故障等级'")
    private String warLevel;
    @Column(columnDefinition = "VARCHAR(255) comment '故障信息'")
    private String warMessage;
    @Column(columnDefinition = "VARCHAR(255) comment '故障单位'")
    private String warUnit;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getWarCode() {
        return warCode;
    }

    public void setWarCode(String warCode) {
        this.warCode = warCode;
    }

    public String getWarTags() {
        return warTags;
    }

    public void setWarTags(String warTags) {
        this.warTags = warTags;
    }

    public String getWarLevel() {
        return warLevel;
    }

    public void setWarLevel(String warLevel) {
        this.warLevel = warLevel;
    }

    public String getWarMessage() {
        return warMessage;
    }

    public void setWarMessage(String warMessage) {
        this.warMessage = warMessage;
    }

    public String getWarUnit() {
        return warUnit;
    }

    public void setWarUnit(String warUnit) {
        this.warUnit = warUnit;
    }
}