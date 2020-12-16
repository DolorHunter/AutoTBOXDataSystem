package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class CarEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "VARCHAR(50) comment '车辆名'")
    private String carName;
    @Column(columnDefinition = "VARCHAR(20) comment '车身'")
    private String carBody;
    @Column(columnDefinition = "VARCHAR(20) comment '变速箱'")
    private String transmission;
    @Column(columnDefinition = "int comment '座位数'")
    private Integer seatsNumber;
    @Column(columnDefinition = "VARCHAR(20) comment '首次生产年份'")
    private String firstYearOfProduction;
    @Column(columnDefinition = "VARCHAR(20) comment '最后生产年份'")
    private String lastYearOfProduction;
    @Column(columnDefinition = "VARCHAR(20) comment '驱动'")
    private String drive;
    @Column(columnDefinition = "VARCHAR(20) comment '引擎类型'")
    private String engineType;
    @Column(columnDefinition = "VARCHAR(20) comment '燃料'")
    private String fuel;
    @Column(columnDefinition = "int comment '最大功率'")
    private Integer totalMaximumPower;
    @Column(columnDefinition = "int comment '最大扭矩'")
    private Integer totalMaximumTorque;
    @Column(columnDefinition = "int comment '气缸数量'")
    private Integer cylindersNumber;
    @Column(columnDefinition = "int comment '每缸气门'")
    private Integer cylinderValves;
    @Column(columnDefinition = "int comment '气缸容量'")
    private Integer cylinderCapacity;
    @Column(columnDefinition = "VARCHAR(20) comment '气缸x行程'")
    private String boreXStroke;
    @Column(columnDefinition = "VARCHAR(20) comment '压缩率'")
    private String compressionRatio;
    @Column(columnDefinition = "int comment '最大功率'")
    private Integer maxPower;
    @Column(columnDefinition = "int comment '最大功率转速'")
    private Integer maxPowerRPM;
    @Column(columnDefinition = "int comment '最大扭矩'")
    private Integer maxTorque;
    @Column(columnDefinition = "int comment '最大扭矩转速'")
    private Integer maxTorqueRPM;
    @Column(columnDefinition = "VARCHAR(20) comment '燃油系统'")
    private String fuelSystem;
    @Column(columnDefinition = "VARCHAR(20) comment '阀门控制'")
    private String valveControl;
    @Column(columnDefinition = "VARCHAR(20) comment '涡轮增压'")
    private String turbo;
    @Column(columnDefinition = "VARCHAR(20) comment '催化剂'")
    private String catalyst;
    @Column(columnDefinition = "int comment '燃料容量'")
    private Integer fuelTank;
    @Column(columnDefinition = "int comment '电动引擎数量'")
    private Integer electroEnginesNumber;
    @Column(columnDefinition = "int comment '电池类型'")
    private String batteryType;
    @Column(columnDefinition = "int comment '电池容量'")
    private Integer batteryCapacity;
    @Column(columnDefinition = "int comment '电池电压'")
    private Integer batteryVoltage;
    @Column(columnDefinition = "int comment '电池里程'")
    private Integer batteryRange;
    @Column(columnDefinition = "int comment '电量消耗'")
    private Integer powerConsumption;
    @Column(columnDefinition = "int comment '最大速度'")
    private Integer topSpeed;
    @Column(columnDefinition = "double comment '零百加速用时'")
    private Double acceleration;
    @Column(columnDefinition = "double comment '城市每百公里耗油量'")
    private Double cityConsumption;
    @Column(columnDefinition = "double comment '城市每公里耗油量'")
    private Double cityConsumptionKM;
    @Column(columnDefinition = "double comment '额外城市每百公里耗油量'")
    private Double extraUrbanConsumption;
    @Column(columnDefinition = "double comment '额外城市每公里耗油量'")
    private Double extraUrbanConsumptionKM;
    @Column(columnDefinition = "double comment '混合每百公里耗油量'")
    private Double combinedConsumption;
    @Column(columnDefinition = "double comment '混合每公里耗油量'")
    private Double combinedConsumptionKM;
    @Column(columnDefinition = "double comment '每百公里耗油量花费监视'")
    private Double consumptionMonitor;
    @Column(columnDefinition = "double comment '每公里耗油量花费监视'")
    private Double consumptionMonitorKM;
    @Column(columnDefinition = "double comment '每公里二氧化碳排放量'")
    private Double CO2Emissions;
    @Column(columnDefinition = "VARCHAR(1) comment '能源标签'")
    private String energyLabel;
    @Column(columnDefinition = "VARCHAR(20) comment '前轮悬挂'")
    private String frontWheelSuspension;
    @Column(columnDefinition = "VARCHAR(20) comment '后轮悬挂'")
    private String rearWheelSuspension;
    @Column(columnDefinition = "VARCHAR(20) comment '前悬挂'")
    private String frontSuspension;
    @Column(columnDefinition = "VARCHAR(20) comment '后悬挂'")
    private String rearSuspension;
    @Column(columnDefinition = "VARCHAR(5) comment '前稳定器'")
    private String frontStabilizer;
    @Column(columnDefinition = "VARCHAR(5) comment '后稳定器'")
    private String rearStabilizer;
    @Column(columnDefinition = "VARCHAR(20) comment '前轮刹车'")
    private String frontBrakes;
    @Column(columnDefinition = "VARCHAR(20) comment '后轮刹车'")
    private String rearBrakes;
    @Column(columnDefinition = "VARCHAR(10) comment '前轮尺寸'")
    private String frontTireSize;
    @Column(columnDefinition = "VARCHAR(10) comment '后轮尺寸'")
    private String rearTireSize;
    @Column(columnDefinition = "double comment '转弯半径'")
    private Double turningRadius;
    @Column(columnDefinition = "double comment '一档变速'")
    private Double _1stGear;
    @Column(columnDefinition = "double comment '二档变速'")
    private Double _2ndGear;
    @Column(columnDefinition = "double comment '三档变速'")
    private Double _3rdGear;
    @Column(columnDefinition = "double comment '四档变速'")
    private Double _4thGear;
    @Column(columnDefinition = "double comment '五档变速'")
    private Double _5thGear;
    @Column(columnDefinition = "double comment '六档变速'")
    private Double _6thGear;
    @Column(columnDefinition = "double comment '七档变速'")
    private Double _7thGear;
    @Column(columnDefinition = "double comment '八档变速'")
    private Double _8thGear;
    @Column(columnDefinition = "double comment '九档变速'")
    private Double _9thGear;
    @Column(columnDefinition = "double comment '倒车变速'")
    private Double reverseGear;
    @Column(columnDefinition = "double comment '最终变速'")
    private Double finalTransmission;
    @Column(columnDefinition = "double comment '120km/h时转速'")
    private Double RPMAt120kmh;
    @Column(columnDefinition = "VARCHAR(20) comment '保养'")
    private String maintenance;
    @Column(columnDefinition = "VARCHAR(20) comment '一般保修'")
    private String generalWarranty;
    @Column(columnDefinition = "VARCHAR(20) comment '底盘保修'")
    private String chassisWarranty;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getFirstYearOfProduction() {
        return firstYearOfProduction;
    }

    public void setFirstYearOfProduction(String firstYearOfProduction) {
        this.firstYearOfProduction = firstYearOfProduction;
    }

    public String getLastYearOfProduction() {
        return lastYearOfProduction;
    }

    public void setLastYearOfProduction(String lastYearOfProduction) {
        this.lastYearOfProduction = lastYearOfProduction;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getTotalMaximumPower() {
        return totalMaximumPower;
    }

    public void setTotalMaximumPower(Integer totalMaximumPower) {
        this.totalMaximumPower = totalMaximumPower;
    }

    public Integer getTotalMaximumTorque() {
        return totalMaximumTorque;
    }

    public void setTotalMaximumTorque(Integer totalMaximumTorque) {
        this.totalMaximumTorque = totalMaximumTorque;
    }

    public Integer getCylindersNumber() {
        return cylindersNumber;
    }

    public void setCylindersNumber(Integer cylindersNumber) {
        this.cylindersNumber = cylindersNumber;
    }

    public Integer getCylinderValves() {
        return cylinderValves;
    }

    public void setCylinderValves(Integer cylinderValves) {
        this.cylinderValves = cylinderValves;
    }

    public Integer getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Integer cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getBoreXStroke() {
        return boreXStroke;
    }

    public void setBoreXStroke(String boreXStroke) {
        this.boreXStroke = boreXStroke;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(String compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public Integer getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Integer maxPower) {
        this.maxPower = maxPower;
    }

    public Integer getMaxPowerRPM() {
        return maxPowerRPM;
    }

    public void setMaxPowerRPM(Integer maxPowerRPM) {
        this.maxPowerRPM = maxPowerRPM;
    }

    public Integer getMaxTorque() {
        return maxTorque;
    }

    public void setMaxTorque(Integer maxTorque) {
        this.maxTorque = maxTorque;
    }

    public Integer getMaxTorqueRPM() {
        return maxTorqueRPM;
    }

    public void setMaxTorqueRPM(Integer maxTorqueRPM) {
        this.maxTorqueRPM = maxTorqueRPM;
    }

    public String getFuelSystem() {
        return fuelSystem;
    }

    public void setFuelSystem(String fuelSystem) {
        this.fuelSystem = fuelSystem;
    }

    public String getValveControl() {
        return valveControl;
    }

    public void setValveControl(String valveControl) {
        this.valveControl = valveControl;
    }

    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }

    public String getCatalyst() {
        return catalyst;
    }

    public void setCatalyst(String catalyst) {
        this.catalyst = catalyst;
    }

    public Integer getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(Integer fuelTank) {
        this.fuelTank = fuelTank;
    }

    public Integer getElectroEnginesNumber() {
        return electroEnginesNumber;
    }

    public void setElectroEnginesNumber(Integer electroEnginesNumber) {
        this.electroEnginesNumber = electroEnginesNumber;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public Integer getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(Integer batteryRange) {
        this.batteryRange = batteryRange;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(Integer topSpeed) {
        this.topSpeed = topSpeed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public Double getCityConsumption() {
        return cityConsumption;
    }

    public void setCityConsumption(Double cityConsumption) {
        this.cityConsumption = cityConsumption;
    }

    public Double getCityConsumptionKM() {
        return cityConsumptionKM;
    }

    public void setCityConsumptionKM(Double cityConsumptionKM) {
        this.cityConsumptionKM = cityConsumptionKM;
    }

    public Double getExtraUrbanConsumption() {
        return extraUrbanConsumption;
    }

    public void setExtraUrbanConsumption(Double extraUrbanConsumption) {
        this.extraUrbanConsumption = extraUrbanConsumption;
    }

    public Double getExtraUrbanConsumptionKM() {
        return extraUrbanConsumptionKM;
    }

    public void setExtraUrbanConsumptionKM(Double extraUrbanConsumptionKM) {
        this.extraUrbanConsumptionKM = extraUrbanConsumptionKM;
    }

    public Double getCombinedConsumption() {
        return combinedConsumption;
    }

    public void setCombinedConsumption(Double combinedConsumption) {
        this.combinedConsumption = combinedConsumption;
    }

    public Double getCombinedConsumptionKM() {
        return combinedConsumptionKM;
    }

    public void setCombinedConsumptionKM(Double combinedConsumptionKM) {
        this.combinedConsumptionKM = combinedConsumptionKM;
    }

    public Double getConsumptionMonitor() {
        return consumptionMonitor;
    }

    public void setConsumptionMonitor(Double consumptionMonitor) {
        this.consumptionMonitor = consumptionMonitor;
    }

    public Double getConsumptionMonitorKM() {
        return consumptionMonitorKM;
    }

    public void setConsumptionMonitorKM(Double consumptionMonitorKM) {
        this.consumptionMonitorKM = consumptionMonitorKM;
    }

    public Double getCO2Emissions() {
        return CO2Emissions;
    }

    public void setCO2Emissions(Double CO2Emissions) {
        this.CO2Emissions = CO2Emissions;
    }

    public String getEnergyLabel() {
        return energyLabel;
    }

    public void setEnergyLabel(String energyLabel) {
        this.energyLabel = energyLabel;
    }

    public String getFrontWheelSuspension() {
        return frontWheelSuspension;
    }

    public void setFrontWheelSuspension(String frontWheelSuspension) {
        this.frontWheelSuspension = frontWheelSuspension;
    }

    public String getRearWheelSuspension() {
        return rearWheelSuspension;
    }

    public void setRearWheelSuspension(String rearWheelSuspension) {
        this.rearWheelSuspension = rearWheelSuspension;
    }

    public String getFrontSuspension() {
        return frontSuspension;
    }

    public void setFrontSuspension(String frontSuspension) {
        this.frontSuspension = frontSuspension;
    }

    public String getRearSuspension() {
        return rearSuspension;
    }

    public void setRearSuspension(String rearSuspension) {
        this.rearSuspension = rearSuspension;
    }

    public String getFrontStabilizer() {
        return frontStabilizer;
    }

    public void setFrontStabilizer(String frontStabilizer) {
        this.frontStabilizer = frontStabilizer;
    }

    public String getRearStabilizer() {
        return rearStabilizer;
    }

    public void setRearStabilizer(String rearStabilizer) {
        this.rearStabilizer = rearStabilizer;
    }

    public String getFrontBrakes() {
        return frontBrakes;
    }

    public void setFrontBrakes(String frontBrakes) {
        this.frontBrakes = frontBrakes;
    }

    public String getRearBrakes() {
        return rearBrakes;
    }

    public void setRearBrakes(String rearBrakes) {
        this.rearBrakes = rearBrakes;
    }

    public String getFrontTireSize() {
        return frontTireSize;
    }

    public void setFrontTireSize(String frontTireSize) {
        this.frontTireSize = frontTireSize;
    }

    public String getRearTireSize() {
        return rearTireSize;
    }

    public void setRearTireSize(String rearTireSize) {
        this.rearTireSize = rearTireSize;
    }

    public Double getTurningRadius() {
        return turningRadius;
    }

    public void setTurningRadius(Double turningRadius) {
        this.turningRadius = turningRadius;
    }

    public Double get_1stGear() {
        return _1stGear;
    }

    public void set_1stGear(Double _1stGear) {
        this._1stGear = _1stGear;
    }

    public Double get_2ndGear() {
        return _2ndGear;
    }

    public void set_2ndGear(Double _2ndGear) {
        this._2ndGear = _2ndGear;
    }

    public Double get_3rdGear() {
        return _3rdGear;
    }

    public void set_3rdGear(Double _3rdGear) {
        this._3rdGear = _3rdGear;
    }

    public Double get_4thGear() {
        return _4thGear;
    }

    public void set_4thGear(Double _4thGear) {
        this._4thGear = _4thGear;
    }

    public Double get_5thGear() {
        return _5thGear;
    }

    public void set_5thGear(Double _5thGear) {
        this._5thGear = _5thGear;
    }

    public Double get_6thGear() {
        return _6thGear;
    }

    public void set_6thGear(Double _6thGear) {
        this._6thGear = _6thGear;
    }

    public Double get_7thGear() {
        return _7thGear;
    }

    public void set_7thGear(Double _7thGear) {
        this._7thGear = _7thGear;
    }

    public Double get_8thGear() {
        return _8thGear;
    }

    public void set_8thGear(Double _8thGear) {
        this._8thGear = _8thGear;
    }

    public Double get_9thGear() {
        return _9thGear;
    }

    public void set_9thGear(Double _9thGear) {
        this._9thGear = _9thGear;
    }

    public Double getReverseGear() {
        return reverseGear;
    }

    public void setReverseGear(Double reverseGear) {
        this.reverseGear = reverseGear;
    }

    public Double getFinalTransmission() {
        return finalTransmission;
    }

    public void setFinalTransmission(Double finalTransmission) {
        this.finalTransmission = finalTransmission;
    }

    public Double getRPMAt120kmh() {
        return RPMAt120kmh;
    }

    public void setRPMAt120kmh(Double RPMAt120kmh) {
        this.RPMAt120kmh = RPMAt120kmh;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getGeneralWarranty() {
        return generalWarranty;
    }

    public void setGeneralWarranty(String generalWarranty) {
        this.generalWarranty = generalWarranty;
    }

    public String getChassisWarranty() {
        return chassisWarranty;
    }

    public void setChassisWarranty(String chassisWarranty) {
        this.chassisWarranty = chassisWarranty;
    }
}
