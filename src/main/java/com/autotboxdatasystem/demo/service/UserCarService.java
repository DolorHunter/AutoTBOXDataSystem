package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserCarEntity;
import org.springframework.data.domain.Page;

public interface UserCarService {
    boolean addCar2User(UserCarEntity userCarEntity);

    void deleteUserCarById(UserCarEntity userCarEntity);

    void deleteUserCarByUserId(UserCarEntity userCarEntity);

    void deleteUserCarByUsername(UserCarEntity userCarEntity);

    void deleteUserCarByCarId(UserCarEntity userCarEntity);

    void deleteUserCarByCarName(UserCarEntity userCarEntity);

    boolean updateStatusById(UserCarEntity userCarEntity);

    boolean updateRemarkById(UserCarEntity userCarEntity);

    UserCarEntity searchUserCarById(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByUserId(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByUsername(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByCarId(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByCarName(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchAllUserCar(UserCarEntity userCarEntity);

}
