package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.CarWarrantyEntity;
import org.springframework.data.domain.Page;

public interface CarWarrantyService {
    boolean addCarWarranty(CarWarrantyEntity carWarrantyEntity);

    void deleteCarWarrantyById(CarWarrantyEntity carWarrantyEntity);
    
    void deleteCarWarrantyByVIN(CarWarrantyEntity carWarrantyEntity);

    boolean updateStatusById(CarWarrantyEntity carWarrantyEntity);

    boolean updateRemarkById(CarWarrantyEntity carWarrantyEntity);

    CarWarrantyEntity searchCarWarrantyById(CarWarrantyEntity carWarrantyEntity);

    Page<CarWarrantyEntity> searchCarWarrantyByVIN(CarWarrantyEntity carWarrantyEntity);

    Page<CarWarrantyEntity> searchAllCarWarranty(CarWarrantyEntity carWarrantyEntity);
}
