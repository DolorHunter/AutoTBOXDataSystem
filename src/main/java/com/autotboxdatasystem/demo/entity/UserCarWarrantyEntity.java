package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class UserCarWarrantyEntity extends BaseEntity{
    @Column(nullable = false, columnDefinition = "int comment '用户车辆ID'")
    private Integer	userCarId;
    @Column(nullable = false, columnDefinition = "varchar(255) comment '整体评价'")
    private String	generalComment;
    @Column(nullable = false, columnDefinition = "int comment '整体分数'")
    private Integer	generalScore;
    @Column(columnDefinition = "varchar(255) comment '驱动评价'")
    private String	driveComment;
    @Column(columnDefinition = "int comment '驱动分数'")
    private Integer	driveScore;
    @Column(columnDefinition = "varchar(255) comment '燃油引擎评价'")
    private String	fuelEngineComment;
    @Column(columnDefinition = "int comment '燃油引擎分数'")
    private Integer	fuelEngineScore;
    @Column(columnDefinition = "varchar(255) comment '性能评价'")
    private String	performanceComment;
    @Column(columnDefinition = "int comment '性能分数'")
    private Integer	performanceScore;
    @Column(columnDefinition = "varchar(255) comment '效能评价'")
    private String	consumptionComment;
    @Column(columnDefinition = "int comment '效能分数'")
    private Integer	consumptionScore;
    @Column(columnDefinition = "varchar(255) comment '车身评价'")
    private String	chassisComment;
    @Column(columnDefinition = "int comment '车身分数'")
    private Integer	chassisScore;
    @Column(columnDefinition = "varchar(255) comment '传动评价'")
    private String	transmissionComment;
    @Column(columnDefinition = "int comment '传动分数'")
    private Integer	transmissionScore;

    public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
    }

    public String getGeneralComment() {
        return generalComment;
    }

    public void setGeneralComment(String generalComment) {
        this.generalComment = generalComment;
    }

    public Integer getGeneralScore() {
        return generalScore;
    }

    public void setGeneralScore(Integer generalScore) {
        this.generalScore = generalScore;
    }

    public String getDriveComment() {
        return driveComment;
    }

    public void setDriveComment(String driveComment) {
        this.driveComment = driveComment;
    }

    public Integer getDriveScore() {
        return driveScore;
    }

    public void setDriveScore(Integer driveScore) {
        this.driveScore = driveScore;
    }

    public String getFuelEngineComment() {
        return fuelEngineComment;
    }

    public void setFuelEngineComment(String fuelEngineComment) {
        this.fuelEngineComment = fuelEngineComment;
    }

    public Integer getFuelEngineScore() {
        return fuelEngineScore;
    }

    public void setFuelEngineScore(Integer fuelEngineScore) {
        this.fuelEngineScore = fuelEngineScore;
    }

    public String getPerformanceComment() {
        return performanceComment;
    }

    public void setPerformanceComment(String performanceComment) {
        this.performanceComment = performanceComment;
    }

    public Integer getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getConsumptionComment() {
        return consumptionComment;
    }

    public void setConsumptionComment(String consumptionComment) {
        this.consumptionComment = consumptionComment;
    }

    public Integer getConsumptionScore() {
        return consumptionScore;
    }

    public void setConsumptionScore(Integer consumptionScore) {
        this.consumptionScore = consumptionScore;
    }

    public String getChassisComment() {
        return chassisComment;
    }

    public void setChassisComment(String chassisComment) {
        this.chassisComment = chassisComment;
    }

    public Integer getChassisScore() {
        return chassisScore;
    }

    public void setChassisScore(Integer chassisScore) {
        this.chassisScore = chassisScore;
    }

    public String getTransmissionComment() {
        return transmissionComment;
    }

    public void setTransmissionComment(String transmissionComment) {
        this.transmissionComment = transmissionComment;
    }

    public Integer getTransmissionScore() {
        return transmissionScore;
    }

    public void setTransmissionScore(Integer transmissionScore) {
        this.transmissionScore = transmissionScore;
    }
}
