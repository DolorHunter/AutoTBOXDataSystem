package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarLogDAO extends PagingAndSortingRepository<CarLogEntity, Integer> {

    void deleteAllByVIN(String VIN);

    Page<CarLogEntity> findByVIN(String VIN, Pageable pageable);

    Page<CarLogEntity> findAll(Pageable pageable);

}
