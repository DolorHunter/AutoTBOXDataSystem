package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    boolean addCar(CarEntity carEntity);

    void activateCarById(CarEntity carEntity);

    void deactivateCarById(CarEntity carEntity);

    void softDeleteCarById(CarEntity carEntity);

    void restoreCarById(CarEntity carEntity);

    void hardDeleteCarById(CarEntity carEntity);

    boolean updateStatusById(CarEntity carEntity);

    boolean updateRemarkById(CarEntity carEntity);

    void updateGeneralById(CarEntity carEntity);

    void updateDriveById(CarEntity carEntity);

    void updateFuelEngineById(CarEntity carEntity);

    void updateElectroMotorById(CarEntity carEntity);

    void updatePerformanceById(CarEntity carEntity);

    void updateChassisById(CarEntity carEntity);

    void updateTransmissionById(CarEntity carEntity);

    void updateServiceAndWarrantyById(CarEntity carEntity);

    CarEntity searchCarById(CarEntity carEntity);

    CarEntity searchCarByCarName(CarEntity carEntity);

    List<CarEntity> searchActivedCarList(CarEntity carEntity);

    Page<CarEntity> searchActivedCarPager(CarEntity carEntity);

    List<CarEntity> searchAllCarList(CarEntity carEntity);

    Page<CarEntity> searchAllCarPager(CarEntity carEntity);
}
