package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarWarningDAO extends PagingAndSortingRepository<CarWarningEntity, Integer> {

    void deleteAllByVIN(String VIN);

    Page<CarWarningEntity> findByVIN(String VIN, Pageable pageable);

    Page<CarWarningEntity> findAll(Pageable pageable);
}
