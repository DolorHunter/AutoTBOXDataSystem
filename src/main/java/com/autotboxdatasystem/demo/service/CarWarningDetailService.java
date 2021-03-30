package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarWarningDetailEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarWarningDetailService {
    boolean addCarWarningDetail(CarWarningDetailEntity carWarningDetailEntity);

    void deleteCarWarningDetailById(CarWarningDetailEntity carWarningDetailEntity);

    void deleteCarWarningDetailByCarType(CarWarningDetailEntity carWarningDetailEntity);

    boolean updateStatusById(CarWarningDetailEntity carWarningDetailEntity);

    boolean updateRemarkById(CarWarningDetailEntity carWarningDetailEntity);

    CarWarningDetailEntity searchCarWarningDetailById(CarWarningDetailEntity carWarningDetailEntity);

    CarWarningDetailEntity searchCarWarningDetailByCarTypeAndErrorContent(CarWarningDetailEntity carWarningDetailEntity);

    List<CarWarningDetailEntity> searchCarWarningDetailByCarTypeList(CarWarningDetailEntity carWarningDetailEntity);

    Page<CarWarningDetailEntity> searchCarWarningDetailByCarTypePager(CarWarningDetailEntity carWarningDetailEntity);

    List<CarWarningDetailEntity> searchAllCarWarningDetailList(CarWarningDetailEntity carWarningDetailEntity);

    Page<CarWarningDetailEntity> searchAllCarWarningDetailPager(CarWarningDetailEntity carWarningDetailEntity);
}
