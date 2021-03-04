package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.UserCarLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCarLogDAO extends PagingAndSortingRepository<UserCarLogEntity, Integer> {

    void deleteAllByUserCarId(Integer userCarId);

    List<UserCarLogEntity> findByUserCarId(Integer userCarId);

    Page<UserCarLogEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserCarLogEntity> findAll(Pageable pageable);

}
