package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserCarLogEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "int comment '用户车辆ID'")
    private Integer userCarId;
    @Column(columnDefinition = "timestamp comment '开机时间'")
    private String startTime;
    @Column(columnDefinition = "timestamp comment '运行时长'")
    private String runTime;
    @Column(columnDefinition = "varchar(64) comment '挡位'")
    private String gear;
    @Column(columnDefinition = "Double comment '行驶里程'")
    private Double drivenRange;
    @Column(columnDefinition = "Double comment '剩余里程'")
    private Double remainingRange;
    @Column(columnDefinition = "Double comment '剩余油量'")
    private Double remainingFuel;
    @Column(columnDefinition = "Double comment '剩余电量'")
    private Double remainingElectroFuel;
    @Column(columnDefinition = "Double comment '车速'")
    private Double speed;
    @Column(columnDefinition = "Double comment '位置'")
    private String location;

    public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public Double getDrivenRange() {
        return drivenRange;
    }

    public void setDrivenRange(Double drivenRange) {
        this.drivenRange = drivenRange;
    }

    public Double getRemainingRange() {
        return remainingRange;
    }

    public void setRemainingRange(Double remainingRange) {
        this.remainingRange = remainingRange;
    }

    public Double getRemainingFuel() {
        return remainingFuel;
    }

    public void setRemainingFuel(Double remainingFuel) {
        this.remainingFuel = remainingFuel;
    }

    public Double getRemainingElectroFuel() {
        return remainingElectroFuel;
    }

    public void setRemainingElectroFuel(Double remainingElectroFuel) {
        this.remainingElectroFuel = remainingElectroFuel;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
