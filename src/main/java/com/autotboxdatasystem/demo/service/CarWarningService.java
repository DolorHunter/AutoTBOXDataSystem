package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarWarningService {
    boolean addCarWarning(CarWarningEntity carWarningEntity);

    void deleteCarWarningById(CarWarningEntity carWarningEntity);

    void deleteCarWarningByVIN(CarWarningEntity carWarningEntity);

    boolean updateStatusById(CarWarningEntity carWarningEntity);

    boolean updateRemarkById(CarWarningEntity carWarningEntity);

    CarWarningEntity searchCarWarningById(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByVIN(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByCarName(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByUnit(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchAllCarWarning(CarWarningEntity carWarningEntity);
}
