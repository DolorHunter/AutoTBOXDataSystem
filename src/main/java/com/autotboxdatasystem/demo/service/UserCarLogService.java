package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserCarLogEntity;
import org.springframework.data.domain.Page;

import java.util.List;
public interface UserCarLogService {    
    boolean addUserCarLog(UserCarLogEntity userCarLogEntity);

    void deleteUserCarLogById(UserCarLogEntity userCarLogEntity);

    void deleteUserCarLogByUserCarId(UserCarLogEntity userCarLogEntity);

    boolean updateStatusById(UserCarLogEntity userCarLogEntity);

    boolean updateRemarkById(UserCarLogEntity userCarLogEntity);

    UserCarLogEntity searchUserCarLogById(UserCarLogEntity userCarLogEntity);

    List<UserCarLogEntity> searchUserCarLogByUserCarId(UserCarLogEntity userCarLogEntity);

    Page<UserCarLogEntity> searchAllUserCarLog(Integer pageIndex, Integer pageSize);

}
