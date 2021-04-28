package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class CarEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "VARCHAR(255) comment '车辆名'")
    private String carName;
    @Column(columnDefinition = "VARCHAR(64) comment '价格'")
    private String price;
    @Column(columnDefinition = "VARCHAR(64) comment '定期技术检查'")
    private String periodicalTechnicalInspection;
    @Column(columnDefinition = "VARCHAR(64) comment '道路税每三月'")
    private String roadTax3Months;
    @Column(columnDefinition = "VARCHAR(64) comment '车身'")
    private String carBody;
    @Column(columnDefinition = "VARCHAR(64) comment '变速箱'")
    private String transmission;
    @Column(columnDefinition = "VARCHAR(4) comment '座位数'")
    private String seatsNumber;
    @Column(columnDefinition = "VARCHAR(16) comment '首次生产年份'")
    private String firstYearOfProduction;
    @Column(columnDefinition = "VARCHAR(16) comment '最后生产年份'")
    private String lastYearOfProduction;
    @Column(columnDefinition = "VARCHAR(64) comment '驱动'")
    private String drive;
    @Column(columnDefinition = "VARCHAR(64) comment '引擎类型'")
    private String engineType;
    @Column(columnDefinition = "VARCHAR(64) comment '燃料'")
    private String fuel;
    @Column(columnDefinition = "VARCHAR(64) comment '最大功率'")
    private String totalMaximumPower;
    @Column(columnDefinition = "VARCHAR(64) comment '最大扭矩'")
    private String totalMaximumTorque;
    @Column(columnDefinition = "VARCHAR(64) comment '气缸数量'")
    private String cylindersNumber;
    @Column(columnDefinition = "VARCHAR(64) comment '每缸气门'")
    private String cylinderValves;
    @Column(columnDefinition = "VARCHAR(64) comment '气缸容量'")
    private String cylinderCapacity;
    @Column(columnDefinition = "VARCHAR(64) comment '气缸x行程'")
    private String boreXStroke;
    @Column(columnDefinition = "VARCHAR(64) comment '压缩率'")
    private String compressionRatio;
    @Column(columnDefinition = "VARCHAR(64) comment '最大功率'")
    private String maxPower;
    @Column(columnDefinition = "VARCHAR(64) comment '最大功率转速'")
    private String maxPowerRPM;
    @Column(columnDefinition = "VARCHAR(64) comment '最大扭矩'")
    private String maxTorque;
    @Column(columnDefinition = "VARCHAR(64) comment '最大扭矩转速'")
    private String maxTorqueRPM;
    @Column(columnDefinition = "VARCHAR(64) comment '燃油系统'")
    private String fuelSystem;
    @Column(columnDefinition = "VARCHAR(64) comment '阀门控制'")
    private String valveControl;
    @Column(columnDefinition = "VARCHAR(64) comment '涡轮增压'")
    private String turbo;
    @Column(columnDefinition = "VARCHAR(64) comment '催化剂'")
    private String catalyst;
    @Column(columnDefinition = "VARCHAR(64) comment '燃料容量'")
    private String fuelTank;
    @Column(columnDefinition = "VARCHAR(64) comment '电动引擎类型'")
    private String electroEngineType;
    @Column(columnDefinition = "VARCHAR(64) comment '电动最大功率'")
    private String electroMaxPower;
    @Column(columnDefinition = "VARCHAR(64) comment '电动最大扭矩'")
    private String electroMaxTorque;
    @Column(columnDefinition = "VARCHAR(64) comment '电动引擎数量'")
    private String electroEnginesNumber;
    @Column(columnDefinition = "VARCHAR(64) comment '电池类型'")
    private String batteryType;
    @Column(columnDefinition = "VARCHAR(64) comment '电池容量'")
    private String batteryCapacity;
    @Column(columnDefinition = "VARCHAR(64) comment '电池电压'")
    private String batteryVoltage;
    @Column(columnDefinition = "VARCHAR(64) comment '电池里程'")
    private String batteryRange;
    @Column(columnDefinition = "VARCHAR(64) comment '电量消耗'")
    private String powerConsumption;
    @Column(columnDefinition = "VARCHAR(64) comment '最大速度'")
    private String topSpeed;
    @Column(columnDefinition = "VARCHAR(64) comment '零百加速用时'")
    private String acceleration;
    @Column(columnDefinition = "VARCHAR(64) comment '城市每百公里耗油量'")
    private String cityConsumption;
    @Column(columnDefinition = "VARCHAR(64) comment '城市每公里耗油量'")
    private String cityConsumptionKM;
    @Column(columnDefinition = "VARCHAR(64) comment '额外城市每百公里耗油量'")
    private String extraUrbanConsumption;
    @Column(columnDefinition = "VARCHAR(64) comment '额外城市每公里耗油量'")
    private String extraUrbanConsumptionKM;
    @Column(columnDefinition = "VARCHAR(64) comment '混合每百公里耗油量'")
    private String combinedConsumption;
    @Column(columnDefinition = "VARCHAR(64) comment '混合每公里耗油量'")
    private String combinedConsumptionKM;
    @Column(columnDefinition = "VARCHAR(64) comment '每百公里耗油量花费监视'")
    private String consumptionMonitor;
    @Column(columnDefinition = "VARCHAR(64) comment '每公里耗油量花费监视'")
    private String consumptionMonitorKM;
    @Column(columnDefinition = "VARCHAR(64) comment '每公里二氧化碳排放量'")
    private String CO2Emissions;
    @Column(columnDefinition = "VARCHAR(64) comment '能源标签'")
    private String energyLabel;
    @Column(columnDefinition = "VARCHAR(64) comment '前轮悬挂'")
    private String frontWheelSuspension;
    @Column(columnDefinition = "VARCHAR(64) comment '后轮悬挂'")
    private String rearWheelSuspension;
    @Column(columnDefinition = "VARCHAR(64) comment '前悬挂'")
    private String frontSuspension;
    @Column(columnDefinition = "VARCHAR(64) comment '后悬挂'")
    private String rearSuspension;
    @Column(columnDefinition = "VARCHAR(64) comment '前稳定器'")
    private String frontStabilizer;
    @Column(columnDefinition = "VARCHAR(64) comment '后稳定器'")
    private String rearStabilizer;
    @Column(columnDefinition = "VARCHAR(64) comment '前轮刹车'")
    private String frontBrakes;
    @Column(columnDefinition = "VARCHAR(64) comment '后轮刹车'")
    private String rearBrakes;
    @Column(columnDefinition = "VARCHAR(64) comment '前轮尺寸'")
    private String frontTireSize;
    @Column(columnDefinition = "VARCHAR(64) comment '后轮尺寸'")
    private String rearTireSize;
    @Column(columnDefinition = "VARCHAR(64) comment '转弯半径'")
    private String turningRadius;
    @Column(columnDefinition = "VARCHAR(64) comment '一档变速'")
    private String _1stGear;
    @Column(columnDefinition = "VARCHAR(64) comment '二档变速'")
    private String _2ndGear;
    @Column(columnDefinition = "VARCHAR(64) comment '三档变速'")
    private String _3rdGear;
    @Column(columnDefinition = "VARCHAR(64) comment '四档变速'")
    private String _4thGear;
    @Column(columnDefinition = "VARCHAR(64) comment '五档变速'")
    private String _5thGear;
    @Column(columnDefinition = "VARCHAR(64) comment '六档变速'")
    private String _6thGear;
    @Column(columnDefinition = "VARCHAR(64) comment '七档变速'")
    private String _7thGear;
    @Column(columnDefinition = "VARCHAR(64) comment '八档变速'")
    private String _8thGear;
    @Column(columnDefinition = "VARCHAR(64) comment '九档变速'")
    private String _9thGear;
    @Column(columnDefinition = "VARCHAR(64) comment '倒车变速'")
    private String reverseGear;
    @Column(columnDefinition = "VARCHAR(64) comment '最终变速'")
    private String finalTransmission;
    @Column(columnDefinition = "VARCHAR(64) comment '120km/h时转速'")
    private String RPMAt120kmh;
    @Column(columnDefinition = "VARCHAR(64) comment '保养'")
    private String maintenance;
    @Column(columnDefinition = "VARCHAR(64) comment '一般保修'")
    private String generalWarranty;
    @Column(columnDefinition = "VARCHAR(64) comment '底盘保修'")
    private String chassisWarranty;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeriodicalTechnicalInspection() {
        return periodicalTechnicalInspection;
    }

    public void setPeriodicalTechnicalInspection(String periodicalTechnicalInspection) {
        this.periodicalTechnicalInspection = periodicalTechnicalInspection;
    }

    public String getRoadTax3Months() {
        return roadTax3Months;
    }

    public void setRoadTax3Months(String roadTax3Months) {
        this.roadTax3Months = roadTax3Months;
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

    public String getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(String seatsNumber) {
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

    public String getTotalMaximumPower() {
        return totalMaximumPower;
    }

    public void setTotalMaximumPower(String totalMaximumPower) {
        this.totalMaximumPower = totalMaximumPower;
    }

    public String getTotalMaximumTorque() {
        return totalMaximumTorque;
    }

    public void setTotalMaximumTorque(String totalMaximumTorque) {
        this.totalMaximumTorque = totalMaximumTorque;
    }

    public String getCylindersNumber() {
        return cylindersNumber;
    }

    public void setCylindersNumber(String cylindersNumber) {
        this.cylindersNumber = cylindersNumber;
    }

    public String getCylinderValves() {
        return cylinderValves;
    }

    public void setCylinderValves(String cylinderValves) {
        this.cylinderValves = cylinderValves;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(String cylinderCapacity) {
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

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower;
    }

    public String getMaxPowerRPM() {
        return maxPowerRPM;
    }

    public void setMaxPowerRPM(String maxPowerRPM) {
        this.maxPowerRPM = maxPowerRPM;
    }

    public String getMaxTorque() {
        return maxTorque;
    }

    public void setMaxTorque(String maxTorque) {
        this.maxTorque = maxTorque;
    }

    public String getMaxTorqueRPM() {
        return maxTorqueRPM;
    }

    public void setMaxTorqueRPM(String maxTorqueRPM) {
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

    public String getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(String fuelTank) {
        this.fuelTank = fuelTank;
    }

    public String getElectroEngineType() {
        return electroEngineType;
    }

    public void setElectroEngineType(String electroEngineType) {
        this.electroEngineType = electroEngineType;
    }

    public String getElectroMaxPower() {
        return electroMaxPower;
    }

    public void setElectroMaxPower(String electroMaxPower) {
        this.electroMaxPower = electroMaxPower;
    }

    public String getElectroMaxTorque() {
        return electroMaxTorque;
    }

    public void setElectroMaxTorque(String electroMaxTorque) {
        this.electroMaxTorque = electroMaxTorque;
    }

    public String getElectroEnginesNumber() {
        return electroEnginesNumber;
    }

    public void setElectroEnginesNumber(String electroEnginesNumber) {
        this.electroEnginesNumber = electroEnginesNumber;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(String batteryRange) {
        this.batteryRange = batteryRange;
    }

    public String getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(String powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public String getCityConsumption() {
        return cityConsumption;
    }

    public void setCityConsumption(String cityConsumption) {
        this.cityConsumption = cityConsumption;
    }

    public String getCityConsumptionKM() {
        return cityConsumptionKM;
    }

    public void setCityConsumptionKM(String cityConsumptionKM) {
        this.cityConsumptionKM = cityConsumptionKM;
    }

    public String getExtraUrbanConsumption() {
        return extraUrbanConsumption;
    }

    public void setExtraUrbanConsumption(String extraUrbanConsumption) {
        this.extraUrbanConsumption = extraUrbanConsumption;
    }

    public String getExtraUrbanConsumptionKM() {
        return extraUrbanConsumptionKM;
    }

    public void setExtraUrbanConsumptionKM(String extraUrbanConsumptionKM) {
        this.extraUrbanConsumptionKM = extraUrbanConsumptionKM;
    }

    public String getCombinedConsumption() {
        return combinedConsumption;
    }

    public void setCombinedConsumption(String combinedConsumption) {
        this.combinedConsumption = combinedConsumption;
    }

    public String getCombinedConsumptionKM() {
        return combinedConsumptionKM;
    }

    public void setCombinedConsumptionKM(String combinedConsumptionKM) {
        this.combinedConsumptionKM = combinedConsumptionKM;
    }

    public String getConsumptionMonitor() {
        return consumptionMonitor;
    }

    public void setConsumptionMonitor(String consumptionMonitor) {
        this.consumptionMonitor = consumptionMonitor;
    }

    public String getConsumptionMonitorKM() {
        return consumptionMonitorKM;
    }

    public void setConsumptionMonitorKM(String consumptionMonitorKM) {
        this.consumptionMonitorKM = consumptionMonitorKM;
    }

    public String getCO2Emissions() {
        return CO2Emissions;
    }

    public void setCO2Emissions(String CO2Emissions) {
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

    public String getTurningRadius() {
        return turningRadius;
    }

    public void setTurningRadius(String turningRadius) {
        this.turningRadius = turningRadius;
    }

    public String get_1stGear() {
        return _1stGear;
    }

    public void set_1stGear(String _1stGear) {
        this._1stGear = _1stGear;
    }

    public String get_2ndGear() {
        return _2ndGear;
    }

    public void set_2ndGear(String _2ndGear) {
        this._2ndGear = _2ndGear;
    }

    public String get_3rdGear() {
        return _3rdGear;
    }

    public void set_3rdGear(String _3rdGear) {
        this._3rdGear = _3rdGear;
    }

    public String get_4thGear() {
        return _4thGear;
    }

    public void set_4thGear(String _4thGear) {
        this._4thGear = _4thGear;
    }

    public String get_5thGear() {
        return _5thGear;
    }

    public void set_5thGear(String _5thGear) {
        this._5thGear = _5thGear;
    }

    public String get_6thGear() {
        return _6thGear;
    }

    public void set_6thGear(String _6thGear) {
        this._6thGear = _6thGear;
    }

    public String get_7thGear() {
        return _7thGear;
    }

    public void set_7thGear(String _7thGear) {
        this._7thGear = _7thGear;
    }

    public String get_8thGear() {
        return _8thGear;
    }

    public void set_8thGear(String _8thGear) {
        this._8thGear = _8thGear;
    }

    public String get_9thGear() {
        return _9thGear;
    }

    public void set_9thGear(String _9thGear) {
        this._9thGear = _9thGear;
    }

    public String getReverseGear() {
        return reverseGear;
    }

    public void setReverseGear(String reverseGear) {
        this.reverseGear = reverseGear;
    }

    public String getFinalTransmission() {
        return finalTransmission;
    }

    public void setFinalTransmission(String finalTransmission) {
        this.finalTransmission = finalTransmission;
    }

    public String getRPMAt120kmh() {
        return RPMAt120kmh;
    }

    public void setRPMAt120kmh(String RPMAt120kmh) {
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
