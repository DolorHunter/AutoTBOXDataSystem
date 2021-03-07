package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class CarLogEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "varchar(64) comment '车辆识别号码'")
    private String VIN;
    @Column(columnDefinition = "varchar(64) comment '开机时间'")
    private String bootTime;
    @Column(columnDefinition = "varchar(64) comment '运行时长'")
    private String runTime;
    @Column(columnDefinition = "varchar(64) comment '挡位'")
    private String gear;
    @Column(columnDefinition = "Double comment '行驶里程'")
    private Double odometer;
    @Column(columnDefinition = "Double comment '累计里程'")
    private Double odometerAcc;
    @Column(columnDefinition = "Double comment '剩余里程'")
    private Double odometerRem;
    @Column(columnDefinition = "Double comment '剩余油量'")
    private Double fuelRem;
    @Column(columnDefinition = "Double comment '剩余电量'")
    private Double electroFuelRem;
    @Column(columnDefinition = "Double comment '车速'")
    private Double speed;
    @Column(columnDefinition = "Double comment '转速'")
    private Double RPM;
    @Column(columnDefinition = "varchar(64) comment '位置'")
    private String location;
    @Column(columnDefinition = "varchar(64) comment '方向'")
    private String heading;
    @Column(columnDefinition = "Double comment '高度'")
    private Double altitude;
    @Column(columnDefinition = "Double comment '温度'")
    private Double temperature;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getBootTime() {
        return bootTime;
    }

    public void setBootTime(String bootTime) {
        this.bootTime = bootTime;
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

    public Double getOdometer() {
        return odometer;
    }

    public void setOdometer(Double odometer) {
        this.odometer = odometer;
    }

    public Double getOdometerAcc() {
        return odometerAcc;
    }

    public void setOdometerAcc(Double odometerAcc) {
        this.odometerAcc = odometerAcc;
    }

    public Double getOdometerRem() {
        return odometerRem;
    }

    public void setOdometerRem(Double odometerRem) {
        this.odometerRem = odometerRem;
    }

    public Double getFuelRem() {
        return fuelRem;
    }

    public void setFuelRem(Double fuelRem) {
        this.fuelRem = fuelRem;
    }

    public Double getElectroFuelRem() {
        return electroFuelRem;
    }

    public void setElectroFuelRem(Double electroFuelRem) {
        this.electroFuelRem = electroFuelRem;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getRPM() {
        return RPM;
    }

    public void setRPM(Double RPM) {
        this.RPM = RPM;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
