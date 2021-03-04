package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.UserCarWarrantyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCarWarrantyDAO extends PagingAndSortingRepository<UserCarWarrantyEntity, Integer> {

    void deleteAllByUserCarId(Integer userCarId);

    List<UserCarWarrantyEntity> findByUserCarId(Integer userCarId);

    Page<UserCarWarrantyEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserCarWarrantyEntity> findAll(Pageable pageable);
}
