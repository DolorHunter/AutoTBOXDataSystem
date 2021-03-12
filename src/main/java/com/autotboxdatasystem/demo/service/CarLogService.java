package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarLogEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarLogService {    
    boolean addCarLog(CarLogEntity carLogEntity);

    void deleteCarLogById(CarLogEntity carLogEntity);

    void deleteCarLogByVIN(CarLogEntity carLogEntity);

    boolean updateStatusById(CarLogEntity carLogEntity);

    boolean updateRemarkById(CarLogEntity carLogEntity);

    CarLogEntity searchCarLogById(CarLogEntity carLogEntity);

    List<CarLogEntity> searchCarLogByVINList(CarLogEntity carLogEntity);

    Page<CarLogEntity> searchCarLogByVINPager(CarLogEntity carLogEntity);

    List<CarLogEntity> searchAllCarLogList(CarLogEntity carLogEntity);

    Page<CarLogEntity> searchAllCarLogPager(CarLogEntity carLogEntity);
}
