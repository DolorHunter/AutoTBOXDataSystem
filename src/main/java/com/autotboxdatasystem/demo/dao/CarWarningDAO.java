package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarWarningDAO extends PagingAndSortingRepository<CarWarningEntity, Integer> {

    void deleteAllByVin(String Vin);

    List<CarWarningEntity> findByVin(String Vin);

    Page<CarWarningEntity> findByVin(String Vin, Pageable pageable);

    List<CarWarningEntity> findByErrorContent(String error_content);

    Page<CarWarningEntity> findByErrorContent(String error_content, Pageable pageable);

    List<CarWarningEntity> findByFaultCategory(String fault_category);

    Page<CarWarningEntity> findByFaultCategory(String fault_category, Pageable pageable);

    List<CarWarningEntity> findAll();

    Page<CarWarningEntity> findAll(Pageable pageable);
}
