package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarWarningDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarWarningDetailDAO extends PagingAndSortingRepository<CarWarningDetailEntity, Integer> {

    void deleteAllByCarType(String carType);

    CarWarningDetailEntity findByCarTypeAndErrorContent(String carType, String errorContent);

    List<CarWarningDetailEntity> findByCarType(String carType);

    Page<CarWarningDetailEntity> findByCarType(String carType, Pageable pageable);

    List<CarWarningDetailEntity> findAll();

    Page<CarWarningDetailEntity> findAll(Pageable pageable);
}
