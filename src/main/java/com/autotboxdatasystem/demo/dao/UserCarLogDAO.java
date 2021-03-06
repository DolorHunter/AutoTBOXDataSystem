package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.UserCarLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCarLogDAO extends PagingAndSortingRepository<UserCarLogEntity, Integer> {

    void deleteAllByUserCarId(Integer userCarId);

    Page<UserCarLogEntity> findByUserCarId(Integer userCarId, Pageable pageable);

    Page<UserCarLogEntity> findAll(Pageable pageable);

}
