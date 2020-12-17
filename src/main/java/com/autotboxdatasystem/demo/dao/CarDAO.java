package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDAO extends PagingAndSortingRepository<CarEntity, Integer> {

    CarEntity findByCarName(String carName);

    List<CarEntity> findByCreatedBy(String username);

    List<CarEntity> findByLastUpdatedBy(String username);

    Page<CarEntity> findByIsActivated(String active, Pageable pageable);

    Page<CarEntity> findAll(Pageable pageable);
}