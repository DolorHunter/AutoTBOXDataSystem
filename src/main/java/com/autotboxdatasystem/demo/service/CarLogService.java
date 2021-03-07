package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarLogEntity;
import org.springframework.data.domain.Page;

public interface CarLogService {    
    boolean addCarLog(CarLogEntity carLogEntity);

    void deleteCarLogById(CarLogEntity carLogEntity);

    void deleteCarLogByVIN(CarLogEntity carLogEntity);

    boolean updateStatusById(CarLogEntity carLogEntity);

    boolean updateRemarkById(CarLogEntity carLogEntity);

    CarLogEntity searchCarLogById(CarLogEntity carLogEntity);

    Page<CarLogEntity> searchCarLogByVIN(CarLogEntity carLogEntity);

    Page<CarLogEntity> searchAllCarLog(CarLogEntity carLogEntity);
}
