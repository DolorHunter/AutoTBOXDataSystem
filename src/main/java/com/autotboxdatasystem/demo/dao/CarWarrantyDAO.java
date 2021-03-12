package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarWarrantyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarWarrantyDAO extends PagingAndSortingRepository<CarWarrantyEntity, Integer> {

    void deleteAllByVIN(String VIN);

    List<CarWarrantyEntity> findByVIN(String VIN);

    Page<CarWarrantyEntity> findByVIN(String VIN, Pageable pageable);

    List<CarWarrantyEntity> findAll();

    Page<CarWarrantyEntity> findAll(Pageable pageable);
}
