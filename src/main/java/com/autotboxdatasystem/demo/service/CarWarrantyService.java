package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarWarrantyEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarWarrantyService {
    boolean addCarWarranty(CarWarrantyEntity carWarrantyEntity);

    void deleteCarWarrantyById(CarWarrantyEntity carWarrantyEntity);
    
    void deleteCarWarrantyByVIN(CarWarrantyEntity carWarrantyEntity);

    boolean updateStatusById(CarWarrantyEntity carWarrantyEntity);

    boolean updateRemarkById(CarWarrantyEntity carWarrantyEntity);

    CarWarrantyEntity searchCarWarrantyById(CarWarrantyEntity carWarrantyEntity);

    List<CarWarrantyEntity> searchCarWarrantyByVINList(CarWarrantyEntity carWarrantyEntity);

    Page<CarWarrantyEntity> searchCarWarrantyByVINPager(CarWarrantyEntity carWarrantyEntity);

    List<CarWarrantyEntity> searchAllCarWarrantyList(CarWarrantyEntity carWarrantyEntity);

    Page<CarWarrantyEntity> searchAllCarWarrantyPager(CarWarrantyEntity carWarrantyEntity);
}
