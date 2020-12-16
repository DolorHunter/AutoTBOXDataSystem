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

    List<UserCarEntity> findByUsername(String username);

    List<UserCarEntity> findByCarId(Integer carId);

    List<UserCarEntity> findByCarName(String carName);

    UserCarEntity findByUserIdAndCarId(Integer userId, Integer carId);

    UserCarEntity findByUsernameAndCarName(String username, String carName);

    List<UserCarEntity> findByCreatedBy(String username);

    List<UserCarEntity> findByLastUpdatedBy(String username);

    Page<UserCarEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserCarEntity> findAll(Pageable pageable);

}
