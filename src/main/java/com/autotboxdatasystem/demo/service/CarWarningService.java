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

    List<CarWarningEntity> searchCarWarningByVINList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByVINPager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchCarWarningByCarNameList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByCarNamePager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchCarWarningByUnitList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByUnitPager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchAllCarWarningList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchAllCarWarningPager(CarWarningEntity carWarningEntity);
}
