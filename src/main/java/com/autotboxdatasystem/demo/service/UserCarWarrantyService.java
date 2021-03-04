package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserCarWarrantyEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserCarWarrantyService {
    boolean addUserCarWarranty(UserCarWarrantyEntity userCarWarrantyEntity);

    void deleteUserCarWarrantyById(UserCarWarrantyEntity userCarWarrantyEntity);
    
    void deleteUserCarWarrantyByUserCarId(UserCarWarrantyEntity userCarWarrantyEntity);

    boolean updateStatusById(UserCarWarrantyEntity userCarWarrantyEntity);

    boolean updateRemarkById(UserCarWarrantyEntity userCarWarrantyEntity);

    UserCarWarrantyEntity searchUserCarWarrantyById(UserCarWarrantyEntity userCarWarrantyEntity);

    List<UserCarWarrantyEntity> searchUserCarWarrantyByUserCarId(UserCarWarrantyEntity userCarWarrantyEntity);

    Page<UserCarWarrantyEntity> searchAllUserCarWarranty(Integer pageIndex, Integer pageSize);

}
