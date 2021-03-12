package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarWarningDAO extends PagingAndSortingRepository<CarWarningEntity, Integer> {

    void deleteAllByVIN(String VIN);

    List<CarWarningEntity> findByVIN(String VIN);

    Page<CarWarningEntity> findByVIN(String VIN, Pageable pageable);

    List<CarWarningEntity> findByCarName(String carName);

    Page<CarWarningEntity> findByCarName(String carName, Pageable pageable);

    List<CarWarningEntity> findByWarUnit(String warUnit);

    Page<CarWarningEntity> findByWarUnit(String warUnit, Pageable pageable);

    List<CarWarningEntity> findAll();

    Page<CarWarningEntity> findAll(Pageable pageable);
}
