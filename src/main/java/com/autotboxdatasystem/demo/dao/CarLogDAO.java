package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarLogDAO extends PagingAndSortingRepository<CarLogEntity, Integer> {

    void deleteAllByVIN(String VIN);

    List<CarLogEntity> findByVIN(String VIN);

    Page<CarLogEntity> findByVIN(String VIN, Pageable pageable);

    List<CarLogEntity> findAll();

    Page<CarLogEntity> findAll(Pageable pageable);

}
