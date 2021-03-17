package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserCarEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserCarService {
    boolean addCar2User(UserCarEntity userCarEntity);

    void deleteUserCarById(UserCarEntity userCarEntity);

    void deleteUserCarByUserId(UserCarEntity userCarEntity);

    void deleteUserCarByUsername(UserCarEntity userCarEntity);

    void deleteUserCarByCarId(UserCarEntity userCarEntity);

    void deleteUserCarByCarName(UserCarEntity userCarEntity);

    void deleteUserCarByVin(UserCarEntity userCarEntity);

    boolean updateStatusById(UserCarEntity userCarEntity);

    boolean updateRemarkById(UserCarEntity userCarEntity);

    UserCarEntity searchUserCarById(UserCarEntity userCarEntity);

    UserCarEntity searchUserCarByVin(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByUserIdList(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByUserIdPager(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByUsernameList(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByUsernamePager(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByCarIdList(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByCarIdPager(UserCarEntity userCarEntity);

    List<UserCarEntity> searchUserCarByCarNameList(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchUserCarByCarNamePager(UserCarEntity userCarEntity);

    List<UserCarEntity> searchAllUserCarList(UserCarEntity userCarEntity);

    Page<UserCarEntity> searchAllUserCarPager(UserCarEntity userCarEntity);

}
