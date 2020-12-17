package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.CarDAO;
import com.autotboxdatasystem.demo.dao.UserCarDAO;
import com.autotboxdatasystem.demo.entity.CarEntity;
import com.autotboxdatasystem.demo.entity.UserCarEntity;
import com.autotboxdatasystem.demo.service.CarService;
import com.autotboxdatasystem.demo.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDAO carDAO;
    private final UserCarDAO userCarDAO;

    public CarServiceImpl(CarDAO carDAO, UserCarDAO userCarDAO) {
        this.carDAO = carDAO;
        this.userCarDAO = userCarDAO;
    }

    @Override
    public boolean addCar(CarEntity carEntity) {
        CarEntity car = carDAO.findByCarName(carEntity.getCarName());
        if (car != null) {
            return false;
        }

        carEntity.setIsActivated("1");
        carEntity.setIsDeleted("0");

        carEntity.setCreatedDate(DateUtil.getCurDateTime());
        carEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        carDAO.save(carEntity);
        return true;
    }

    @Override
    public void activateCarById(CarEntity carEntity) {
        List<UserCarEntity> userCarList = userCarDAO.findByCarId(carEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("1");
                userCar.setLastUpdatedBy(carEntity.getLastUpdatedBy());
                userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                userCarDAO.save(userCar);
            }
        }

        CarEntity car = carDAO.findById(carEntity.getId()).get();
        car.setIsActivated("1");
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void deactivateCarById(CarEntity carEntity) {
        List<UserCarEntity> userCarList = userCarDAO.findByCarId(carEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("0");
                userCar.setLastUpdatedBy(carEntity.getLastUpdatedBy());
                userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                userCarDAO.save(userCar);
            }
        }

        CarEntity car = carDAO.findById(carEntity.getId()).get();
        car.setIsActivated("0");
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void softDeleteCarById(CarEntity carEntity) {
        List<UserCarEntity> userCarList = userCarDAO.findByCarId(carEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("0");
                userCar.setIsDeleted("1");
                userCar.setLastUpdatedBy(carEntity.getLastUpdatedBy());
                userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                userCarDAO.save(userCar);
            }
        }

        CarEntity car = carDAO.findById(carEntity.getId()).get();
        car.setIsActivated("0");
        car.setIsDeleted("1");
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void restoreCarById(CarEntity carEntity) {
        List<UserCarEntity> userCarList = userCarDAO.findByCarId(carEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("1");
                userCar.setIsDeleted("0");
                userCar.setLastUpdatedBy(carEntity.getLastUpdatedBy());
                userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                userCarDAO.save(userCar);
            }
        }

        CarEntity car = carDAO.findById(carEntity.getId()).get();
        car.setIsActivated("1");
        car.setIsDeleted("0");
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void hardDeleteCarById(CarEntity carEntity) {
        userCarDAO.deleteAllByCarId(carEntity.getId());
        carDAO.deleteById(carEntity.getId());
    }

    @Override
    public boolean updateStatusById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String status = carEntity.getStatus();
        if (status != null) {
            car.setStatus(status);
            car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
            car.setLastUpdatedDate(DateUtil.getCurDateTime());
            carDAO.save(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String remark = carEntity.getRemark();
        if (remark != null) {
            car.setRemark(remark);
            car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
            car.setLastUpdatedDate(DateUtil.getCurDateTime());
            carDAO.save(car);
            return true;
        }
        return false;
    }

    @Override
    public void updateGeneralById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String image = carEntity.getImage();
        String carName = carEntity.getCarName();
        String price = carEntity.getPrice();
        String periodicalTechnicalInspection = carEntity.getPeriodicalTechnicalInspection();
        String roadTax3Months = carEntity.getRoadTax3Months();
        String carBody = carEntity.getCarBody();
        String transmission = carEntity.getTransmission();
        String seatsNumber = carEntity.getSeatsNumber();
        String firstYearOfProduction = carEntity.getFirstYearOfProduction();
        String lastYearOfProduction = carEntity.getLastYearOfProduction();
        if (image != null) {
            car.setImage(image);
        }
        if (price != null) {
            car.setPrice(price);
        }
        if (periodicalTechnicalInspection != null) {
            car.setPeriodicalTechnicalInspection(periodicalTechnicalInspection);
        }
        if (roadTax3Months != null) {
            car.setRoadTax3Months(roadTax3Months);
        }
        if (carName != null) {
            car.setCarName(carName);
        }
        if (carBody != null) {
            car.setCarBody(carBody);
        }
        if (transmission != null) {
            car.setTransmission(transmission);
        }
        if (seatsNumber != null) {
            car.setSeatsNumber(seatsNumber);
        }
        if (firstYearOfProduction != null) {
            car.setFirstYearOfProduction(firstYearOfProduction);
        }
        if (lastYearOfProduction != null) {
            car.setLastYearOfProduction(lastYearOfProduction);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updateDriveById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String drive = carEntity.getDrive();
        String engineType = carEntity.getEngineType();
        String fuel = carEntity.getFuel();
        String totalMaximumPower = carEntity.getTotalMaximumPower();
        String totalMaximumTorque = carEntity.getTotalMaximumTorque();
        if (drive != null) {
            car.setDrive(drive);
        }
        if (engineType != null) {
            car.setEngineType(engineType);
        }
        if (fuel != null) {
            car.setFuel(fuel);
        }
        if (totalMaximumPower != null) {
            car.setTotalMaximumPower(totalMaximumPower);
        }
        if (totalMaximumTorque != null) {
            car.setTotalMaximumTorque(totalMaximumTorque);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updateFuelEngineById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String cylindersNumber = carEntity.getCylindersNumber();
        String cylinderValves = carEntity.getCylinderValves();
        String cylinderCapacity = carEntity.getCylinderCapacity();
        String boreXStroke = carEntity.getBoreXStroke();
        String compressionRatio = carEntity.getCompressionRatio();
        String maxPower = carEntity.getMaxPower();
        String maxPowerRPM = carEntity.getMaxPowerRPM();
        String maxTorque = carEntity.getMaxTorque();
        String maxTorqueRPM = carEntity.getMaxTorqueRPM();
        String fuelSystem = carEntity.getFuelSystem();
        String valveControl = carEntity.getValveControl();
        String turbo = carEntity.getTurbo();
        String catalyst = carEntity.getCatalyst();
        String fuelTank = carEntity.getFuelTank();
        if (cylindersNumber != null) {
            car.setCylindersNumber(cylindersNumber);
        }
        if (cylinderValves != null) {
            car.setCylinderValves(cylinderValves);
        }
        if (cylinderCapacity != null) {
            car.setCylinderCapacity(cylinderCapacity);
        }
        if (boreXStroke != null) {
            car.setBoreXStroke(boreXStroke);
        }
        if (compressionRatio != null) {
            car.setCompressionRatio(compressionRatio);
        }
        if (maxPower != null) {
            car.setMaxPower(maxPower);
        }
        if (maxPowerRPM != null) {
            car.setMaxPowerRPM(maxPowerRPM);
        }
        if (maxTorque != null) {
            car.setMaxTorque(maxTorque);
        }
        if (maxTorqueRPM != null) {
            car.setMaxTorqueRPM(maxTorqueRPM);
        }
        if (fuelSystem != null) {
            car.setFuelSystem(fuelSystem);
        }
        if (valveControl != null) {
            car.setValveControl(valveControl);
        }
        if (turbo != null) {
            car.setTurbo(turbo);
        }
        if (catalyst != null) {
            car.setCatalyst(catalyst);
        }
        if (fuelTank != null) {
            car.setFuelTank(fuelTank);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updateElectroMotorById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String electroEngineType = carEntity.getElectroEngineType();
        String electroMaxPower = carEntity.getElectroMaxPower();
        String electroMaxTorque = carEntity.getElectroMaxTorque();
        String electroEnginesNumber = carEntity.getElectroEnginesNumber();
        String batteryType = carEntity.getBatteryType();
        String batteryCapacity = carEntity.getBatteryCapacity();
        String batteryVoltage = carEntity.getBatteryVoltage();
        String batteryRange = carEntity.getBatteryRange();
        String powerConsumption = carEntity.getPowerConsumption();
        if (electroEngineType != null) {
            car.setElectroEngineType(electroEngineType);
        }
        if (electroMaxPower != null) {
            car.setElectroMaxPower(electroMaxPower);
        }
        if (electroMaxTorque != null) {
            car.setElectroMaxTorque(electroMaxTorque);
        }
        if (electroEnginesNumber != null) {
            car.setElectroEnginesNumber(electroEnginesNumber);
        }
        if (batteryType != null) {
            car.setBatteryType(batteryType);
        }
        if (batteryCapacity != null) {
            car.setBatteryCapacity(batteryCapacity);
        }
        if (batteryVoltage != null) {
            car.setBatteryVoltage(batteryVoltage);
        }
        if (batteryRange != null) {
            car.setBatteryRange(batteryRange);
        }
        if (powerConsumption != null) {
            car.setPowerConsumption(powerConsumption);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updatePerformanceById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String topSpeed = carEntity.getTopSpeed();
        String acceleration = carEntity.getAcceleration();
        String cityConsumption = carEntity.getCityConsumption();
        String cityConsumptionKM = carEntity.getCityConsumptionKM();
        String extraUrbanConsumption = carEntity.getExtraUrbanConsumption();
        String extraUrbanConsumptionKM = carEntity.getExtraUrbanConsumptionKM();
        String combinedConsumption = carEntity.getCombinedConsumption();
        String combinedConsumptionKM = carEntity.getCombinedConsumptionKM();
        String consumptionMonitor = carEntity.getConsumptionMonitor();
        String consumptionMonitorKM = carEntity.getConsumptionMonitorKM();
        String CO2Emissions = carEntity.getCO2Emissions();
        String energyLabel = carEntity.getEnergyLabel();
        if (topSpeed != null) {
            car.setTopSpeed(topSpeed);
        }
        if (acceleration != null) {
            car.setAcceleration(acceleration);
        }
        if (cityConsumption != null) {
            car.setCityConsumption(cityConsumption);
        }
        if (cityConsumptionKM != null) {
            car.setCityConsumptionKM(cityConsumptionKM);
        }
        if (extraUrbanConsumption != null) {
            car.setExtraUrbanConsumption(extraUrbanConsumption);
        }
        if (extraUrbanConsumptionKM != null) {
            car.setExtraUrbanConsumptionKM(extraUrbanConsumptionKM);
        }
        if (combinedConsumption != null) {
            car.setCombinedConsumption(combinedConsumption);
        }
        if (combinedConsumptionKM != null) {
            car.setCombinedConsumptionKM(combinedConsumptionKM);
        }
        if (consumptionMonitor != null) {
            car.setConsumptionMonitor(consumptionMonitor);
        }
        if (consumptionMonitorKM != null) {
            car.setConsumptionMonitorKM(consumptionMonitorKM);
        }
        if (CO2Emissions != null) {
            car.setCO2Emissions(CO2Emissions);
        }
        if (energyLabel != null) {
            car.setEnergyLabel(energyLabel);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updateChassisById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String frontWheelSuspension = carEntity.getFrontWheelSuspension();
        String rearWheelSuspension = carEntity.getRearWheelSuspension();
        String frontSuspension = carEntity.getFrontSuspension();
        String rearSuspension = carEntity.getRearSuspension();
        String frontStabilizer = carEntity.getFrontStabilizer();
        String rearStabilizer = carEntity.getRearStabilizer();
        String frontBrakes = carEntity.getFrontBrakes();
        String rearBrakes = carEntity.getRearBrakes();
        String frontTireSize = carEntity.getFrontTireSize();
        String rearTireSize = carEntity.getRearTireSize();
        String turningRadius = carEntity.getTurningRadius();
        if (frontWheelSuspension != null) {
            car.setFrontWheelSuspension(frontWheelSuspension);
        }
        if (rearWheelSuspension != null) {
            car.setRearWheelSuspension(rearWheelSuspension);
        }
        if (frontSuspension != null) {
            car.setFrontSuspension(frontSuspension);
        }
        if (rearSuspension != null) {
            car.setRearSuspension(rearSuspension);
        }
        if (frontStabilizer != null) {
            car.setFrontStabilizer(frontStabilizer);
        }
        if (rearStabilizer != null) {
            car.setRearSuspension(rearStabilizer);
        }
        if (frontBrakes != null) {
            car.setFrontBrakes(frontBrakes);
        }
        if (rearBrakes != null) {
            car.setRearBrakes(rearBrakes);
        }
        if (frontTireSize != null) {
            car.setFrontTireSize(frontTireSize);
        }
        if (rearTireSize != null) {
            car.setRearTireSize(rearTireSize);
        }
        if (turningRadius != null) {
            car.setTurningRadius(turningRadius);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updateTransmissionById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String _1stGear = carEntity.get_1stGear();
        String _2ndGear = carEntity.get_2ndGear();
        String _3rdGear = carEntity.get_3rdGear();
        String _4thGear = carEntity.get_4thGear();
        String _5thGear = carEntity.get_5thGear();
        String _6thGear = carEntity.get_6thGear();
        String _7thGear = carEntity.get_7thGear();
        String _8thGear = carEntity.get_8thGear();
        String _9thGear = carEntity.get_9thGear();
        String reverseGear = carEntity.getReverseGear();
        String finalTransmission = carEntity.getFinalTransmission();
        String RPMAt120kmh = carEntity.getRPMAt120kmh();
        if (_1stGear != null) {
            car.set_1stGear(_1stGear);
        }
        if (_2ndGear != null) {
            car.set_2ndGear(_2ndGear);
        }
        if (_3rdGear != null) {
            car.set_3rdGear(_3rdGear);
        }
        if (_4thGear != null) {
            car.set_4thGear(_4thGear);
        }
        if (_5thGear != null) {
            car.set_5thGear(_5thGear);
        }
        if (_6thGear != null) {
            car.set_6thGear(_6thGear);
        }
        if (_7thGear != null) {
            car.set_7thGear(_7thGear);
        }
        if (_8thGear != null) {
            car.set_8thGear(_8thGear);
        }
        if (_9thGear != null) {
            car.set_9thGear(_9thGear);
        }
        if (reverseGear != null) {
            car.setReverseGear(reverseGear);
        }
        if (finalTransmission != null) {
            car.setFinalTransmission(finalTransmission);
        }
        if (RPMAt120kmh != null) {
            car.setRPMAt120kmh(RPMAt120kmh);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public void updateServiceAndWarrantyById(CarEntity carEntity) {
        CarEntity car = carDAO.findById(carEntity.getId()).get();
        String maintenance = carEntity.getMaintenance();
        String generalWarranty = carEntity.getGeneralWarranty();
        String chassisWarranty = carEntity.getChassisWarranty();
        if (maintenance != null) {
            car.setMaintenance(maintenance);
        }
        if (generalWarranty != null) {
            car.setGeneralWarranty(generalWarranty);
        }
        if (chassisWarranty != null) {
            car.setChassisWarranty(chassisWarranty);
        }
        car.setLastUpdatedBy(carEntity.getLastUpdatedBy());
        car.setLastUpdatedDate(DateUtil.getCurDateTime());
        carDAO.save(car);
    }

    @Override
    public CarEntity searchCarById(CarEntity carEntity) {
        return carDAO.findById(carEntity.getId()).get();
    }

    @Override
    public CarEntity searchCarByCarName(CarEntity carEntity) {
        return carDAO.findByCarName(carEntity.getCarName());
    }

    @Override
    public Page<CarEntity> searchActivedCar(Integer pageIndex, Integer pageSize) {
        return carDAO.findByIsActivated("1", PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<CarEntity> searchAllCar(Integer pageIndex, Integer pageSize) {
        return carDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
