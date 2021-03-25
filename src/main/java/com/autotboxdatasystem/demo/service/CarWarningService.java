package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarWarningService {
    boolean addCarWarning(CarWarningEntity carWarningEntity);

    void deleteCarWarningById(CarWarningEntity carWarningEntity);

    void deleteCarWarningByVin(CarWarningEntity carWarningEntity);

    boolean updateStatusById(CarWarningEntity carWarningEntity);

    boolean updateRemarkById(CarWarningEntity carWarningEntity);

    CarWarningEntity searchCarWarningById(CarWarningEntity carWarningEntity);

    CarWarningEntity searchExistCarWarningByVinAndSendingTimeAndErrorContentAndFaultCategory(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchCarWarningByVinList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByVinPager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchCarWarningByErrorContentList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByErrorContentPager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchCarWarningByFaultCategoryList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningByFaultCategoryPager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchCarWarningBySendingTimeBetweenList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchCarWarningBySendingTimeBetweenPager(CarWarningEntity carWarningEntity);

    List<CarWarningEntity> searchAllCarWarningList(CarWarningEntity carWarningEntity);

    Page<CarWarningEntity> searchAllCarWarningPager(CarWarningEntity carWarningEntity);
}
