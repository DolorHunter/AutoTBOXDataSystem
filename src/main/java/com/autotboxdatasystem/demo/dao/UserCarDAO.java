package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.UserCarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCarDAO extends PagingAndSortingRepository<UserCarEntity, Integer> {

    void deleteAllByUserId(Integer userId);

    void deleteAllByUsername(String username);

    void deleteAllByCarId(Integer carId);

    void deleteAllByCarName(String carName);

    List<UserCarEntity> findByUserId(Integer userId);

    Page<UserCarEntity> findByUserId(Integer userId, Pageable pageable);

    List<UserCarEntity> findByUsername(String username);

    Page<UserCarEntity> findByUsername(String username, Pageable pageable);

    List<UserCarEntity> findByCarId(Integer carId);

    Page<UserCarEntity> findByCarId(Integer carId, Pageable pageable);

    List<UserCarEntity> findByCarName(String carName);

    Page<UserCarEntity> findByCarName(String carName, Pageable pageable);

    UserCarEntity findByUserIdAndCarId(Integer userId, Integer carId);

    UserCarEntity findByUsernameAndCarName(String username, String carName);

    List<UserCarEntity> findByIsActivated(String active);

    Page<UserCarEntity> findByIsActivated(String active, Pageable pageable);

    List<UserCarEntity> findAll();

    Page<UserCarEntity> findAll(Pageable pageable);
}
