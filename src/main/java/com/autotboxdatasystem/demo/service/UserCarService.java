package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserCarEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserCarService {
    boolean addCar2User(UserCarEntity userCarEntity);

    void deleteUserCarByUserId(UserCarEntity userCarEntity);

    void deleteUserCarByUsername(UserCarEntity userCarEntity);

    void deleteUserCarByCarId(UserCarEntity userCarEntity);

    void deleteUserCarByCarName(UserCarEntity userCarEntity);

    boolean updateStatusById(UserCarEntity userCarEntity);

    boolean updateRemarkById(UserCarEntity userCarEntity);

    UserCarEntity searchUserCarById(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByUserId(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByUsername(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByCarId(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByCarName(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchAllUserCar(Integer pageIndex, Integer pageSize);

}
