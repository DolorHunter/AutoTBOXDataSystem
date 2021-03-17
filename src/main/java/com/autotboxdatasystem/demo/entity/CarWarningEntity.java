package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class CarWarningEntity extends BaseEntity{
    @Column(columnDefinition = "VARCHAR(64) comment '盲点监控系统故障'")
    private String blindSpotMonitoringSysFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '引擎防盗系统故障'")
    private String EngineTheftPreventionSysFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '电池充电'")
    private String batteryCharging;
    @Column(columnDefinition = "VARCHAR(64) comment '高度'")
    private String altitude;
    @Column(columnDefinition = "VARCHAR(64) comment '传输失败'")
    private String transmissionFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '动力转向系统故障'")
    private String powerSteeringSystemFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '自动停车失败'")
    private String AutoParkingFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '自适应巡航故障'")
    private String adaptiveCruiseFault;
    @Column(columnDefinition = "VARCHAR(64) comment '发动机故障'")
    private String engineFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '稳定系统关闭'")
    private String stabilitySystemShutdown;
    @Column(columnDefinition = "VARCHAR(64) comment '油压'")
    private String OilPressure;
    @Column(columnDefinition = "VARCHAR(64) comment '斜坡减速故障'")
    private String slopeSlowDownFault;
    @Column(columnDefinition = "VARCHAR(64) comment '电子停车'")
    private String ElectronicParking;
    @Column(nullable = false, columnDefinition = "varchar(64) comment '车辆识别号码'")
    private String vin;
    @Column(columnDefinition = "VARCHAR(64) comment '开始停止系统故障'")
    private String startStopSystemFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '挡风玻璃传感器护罩'")
    private String WindshieldSensorShield;
    @Column(columnDefinition = "VARCHAR(64) comment '经度'")
    private String longitude;
    @Column(columnDefinition = "VARCHAR(64) comment '车道偏离系统故障'")
    private String laneDepartureSysFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '经度状态'")
    private String longitudeState;
    @Column(columnDefinition = "VARCHAR(64) comment '方向'")
    private String direct;
    @Column(columnDefinition = "VARCHAR(64) comment '胎压监测系统故障'")
    private String TirePressureMonitoringSysFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '发动机排气系统故障'")
    private String engineExhaustSystemFailure;
    @Column(columnDefinition = "VARCHAR(64) comment '动力转向系统'")
    private String powerSteeringSystemInit;
    @Column(columnDefinition = "VARCHAR(64) comment '自动刹车系统状态'")
    private String AutoBrakSystemStatus;
    @Column(columnDefinition = "VARCHAR(64) comment '纬度州'")
    private String latitudeState;
    @Column(columnDefinition = "VARCHAR(64) comment '位置'")
    private String loc;
    @Column(columnDefinition = "VARCHAR(64) comment '安全气囊故障'")
    private String airbagFault;
    @Column(columnDefinition = "VARCHAR(64) comment '错误内容'")
    private String error_content;
    @Column(columnDefinition = "VARCHAR(64) comment '故障类别'")
    private String fault_category;
    @Column(columnDefinition = "VARCHAR(64) comment '错误列表计数'")
    private String error_list_count;
    @Column(columnDefinition = "VARCHAR(64) comment '电子稳定系统指示'")
    private String ElectronicStabilitySysIndication;
    @Column(columnDefinition = "VARCHAR(64) comment '轮胎压力异常'")
    private String TirePressureAnomaly;
    @Column(columnDefinition = "VARCHAR(64) comment '电子停车故障'")
    private String electronicParkingFailure;
    @Column(columnDefinition = "VARCHAR(64) comment 'gps速度'")
    private String gpsSpeed;
    @Column(columnDefinition = "VARCHAR(64) comment '纬度'")
    private String latitude;
    @Column(columnDefinition = "VARCHAR(64) comment '发送时间'")
    private String sendingTime;
    @Column(columnDefinition = "VARCHAR(64) comment '启动停止系统故障'")
    private String StartStopSystemNotWork;
    @Column(columnDefinition = "VARCHAR(64) comment '自动紧急制动系统故障'")
    private String AutoEmergencyBrakeSysFailure;

    public String getBlindSpotMonitoringSysFailure() {
        return blindSpotMonitoringSysFailure;
    }

    public void setBlindSpotMonitoringSysFailure(String blindSpotMonitoringSysFailure) {
        this.blindSpotMonitoringSysFailure = blindSpotMonitoringSysFailure;
    }

    public String getEngineTheftPreventionSysFailure() {
        return EngineTheftPreventionSysFailure;
    }

    public void setEngineTheftPreventionSysFailure(String engineTheftPreventionSysFailure) {
        EngineTheftPreventionSysFailure = engineTheftPreventionSysFailure;
    }

    public String getBatteryCharging() {
        return batteryCharging;
    }

    public void setBatteryCharging(String batteryCharging) {
        this.batteryCharging = batteryCharging;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getTransmissionFailure() {
        return transmissionFailure;
    }

    public void setTransmissionFailure(String transmissionFailure) {
        this.transmissionFailure = transmissionFailure;
    }

    public String getPowerSteeringSystemFailure() {
        return powerSteeringSystemFailure;
    }

    public void setPowerSteeringSystemFailure(String powerSteeringSystemFailure) {
        this.powerSteeringSystemFailure = powerSteeringSystemFailure;
    }

    public String getAutoParkingFailure() {
        return AutoParkingFailure;
    }

    public void setAutoParkingFailure(String autoParkingFailure) {
        AutoParkingFailure = autoParkingFailure;
    }

    public String getAdaptiveCruiseFault() {
        return adaptiveCruiseFault;
    }

    public void setAdaptiveCruiseFault(String adaptiveCruiseFault) {
        this.adaptiveCruiseFault = adaptiveCruiseFault;
    }

    public String getEngineFailure() {
        return engineFailure;
    }

    public void setEngineFailure(String engineFailure) {
        this.engineFailure = engineFailure;
    }

    public String getStabilitySystemShutdown() {
        return stabilitySystemShutdown;
    }

    public void setStabilitySystemShutdown(String stabilitySystemShutdown) {
        this.stabilitySystemShutdown = stabilitySystemShutdown;
    }

    public String getOilPressure() {
        return OilPressure;
    }

    public void setOilPressure(String oilPressure) {
        OilPressure = oilPressure;
    }

    public String getSlopeSlowDownFault() {
        return slopeSlowDownFault;
    }

    public void setSlopeSlowDownFault(String slopeSlowDownFault) {
        this.slopeSlowDownFault = slopeSlowDownFault;
    }

    public String getElectronicParking() {
        return ElectronicParking;
    }

    public void setElectronicParking(String electronicParking) {
        ElectronicParking = electronicParking;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStartStopSystemFailure() {
        return startStopSystemFailure;
    }

    public void setStartStopSystemFailure(String startStopSystemFailure) {
        this.startStopSystemFailure = startStopSystemFailure;
    }

    public String getWindshieldSensorShield() {
        return WindshieldSensorShield;
    }

    public void setWindshieldSensorShield(String windshieldSensorShield) {
        WindshieldSensorShield = windshieldSensorShield;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLaneDepartureSysFailure() {
        return laneDepartureSysFailure;
    }

    public void setLaneDepartureSysFailure(String laneDepartureSysFailure) {
        this.laneDepartureSysFailure = laneDepartureSysFailure;
    }

    public String getLongitudeState() {
        return longitudeState;
    }

    public void setLongitudeState(String longitudeState) {
        this.longitudeState = longitudeState;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getTirePressureMonitoringSysFailure() {
        return TirePressureMonitoringSysFailure;
    }

    public void setTirePressureMonitoringSysFailure(String tirePressureMonitoringSysFailure) {
        TirePressureMonitoringSysFailure = tirePressureMonitoringSysFailure;
    }

    public String getEngineExhaustSystemFailure() {
        return engineExhaustSystemFailure;
    }

    public void setEngineExhaustSystemFailure(String engineExhaustSystemFailure) {
        this.engineExhaustSystemFailure = engineExhaustSystemFailure;
    }

    public String getPowerSteeringSystemInit() {
        return powerSteeringSystemInit;
    }

    public void setPowerSteeringSystemInit(String powerSteeringSystemInit) {
        this.powerSteeringSystemInit = powerSteeringSystemInit;
    }

    public String getAutoBrakSystemStatus() {
        return AutoBrakSystemStatus;
    }

    public void setAutoBrakSystemStatus(String autoBrakSystemStatus) {
        AutoBrakSystemStatus = autoBrakSystemStatus;
    }

    public String getLatitudeState() {
        return latitudeState;
    }

    public void setLatitudeState(String latitudeState) {
        this.latitudeState = latitudeState;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getAirbagFault() {
        return airbagFault;
    }

    public void setAirbagFault(String airbagFault) {
        this.airbagFault = airbagFault;
    }

    public String getError_content() {
        return error_content;
    }

    public void setError_content(String error_content) {
        this.error_content = error_content;
    }

    public String getFault_category() {
        return fault_category;
    }

    public void setFault_category(String fault_category) {
        this.fault_category = fault_category;
    }

    public String getError_list_count() {
        return error_list_count;
    }

    public void setError_list_count(String error_list_count) {
        this.error_list_count = error_list_count;
    }

    public String getElectronicStabilitySysIndication() {
        return ElectronicStabilitySysIndication;
    }

    public void setElectronicStabilitySysIndication(String electronicStabilitySysIndication) {
        ElectronicStabilitySysIndication = electronicStabilitySysIndication;
    }

    public String getTirePressureAnomaly() {
        return TirePressureAnomaly;
    }

    public void setTirePressureAnomaly(String tirePressureAnomaly) {
        TirePressureAnomaly = tirePressureAnomaly;
    }

    public String getElectronicParkingFailure() {
        return electronicParkingFailure;
    }

    public void setElectronicParkingFailure(String electronicParkingFailure) {
        this.electronicParkingFailure = electronicParkingFailure;
    }

    public String getGpsSpeed() {
        return gpsSpeed;
    }

    public void setGpsSpeed(String gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(String sendingTime) {
        this.sendingTime = sendingTime;
    }

    public String getStartStopSystemNotWork() {
        return StartStopSystemNotWork;
    }

    public void setStartStopSystemNotWork(String startStopSystemNotWork) {
        StartStopSystemNotWork = startStopSystemNotWork;
    }

    public String getAutoEmergencyBrakeSysFailure() {
        return AutoEmergencyBrakeSysFailure;
    }

    public void setAutoEmergencyBrakeSysFailure(String autoEmergencyBrakeSysFailure) {
        AutoEmergencyBrakeSysFailure = autoEmergencyBrakeSysFailure;
    }
}
