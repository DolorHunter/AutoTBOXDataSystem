package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.UserCarDAO;
import com.autotboxdatasystem.demo.entity.UserCarEntity;
import com.autotboxdatasystem.demo.service.UserCarService;
import com.autotboxdatasystem.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCarServiceImpl implements UserCarService {
    private final UserCarDAO userCarDAO;

    @Autowired
    public UserCarServiceImpl(UserCarDAO userCarDAO) {
        this.userCarDAO = userCarDAO;
    }

    @Override
    public boolean addCar2User(UserCarEntity userCarEntity) {
        Integer userId = userCarEntity.getUserId();
        Integer carId = userCarEntity.getCarId();
        UserCarEntity userCar = userCarDAO.findByUserIdAndCarId(userId, carId);
        if (userCar != null) {
            return false;
        }

        userCarEntity.setIsActivated("1");
        userCarEntity.setIsDeleted("0");

        userCarEntity.setCreatedDate(DateUtil.getCurDateTime());
        userCarEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userCarDAO.save(userCarEntity);
        return true;
    }

    @Override
    public void deleteUserCarByUserId(UserCarEntity userCarEntity) {
        userCarDAO.deleteAllByUserId(userCarEntity.getUserId());
    }

    @Override
    public void deleteUserCarByUsername(UserCarEntity userCarEntity) {
        userCarDAO.deleteAllByUsername(userCarEntity.getUsername());
    }

    @Override
    public void deleteUserCarByCarId(UserCarEntity userCarEntity) {
        userCarDAO.deleteAllByCarId(userCarEntity.getCarId());
    }

    @Override
    public void deleteUserCarByCarName(UserCarEntity userCarEntity) {
        userCarDAO.deleteAllByCarName(userCarEntity.getCarName());
    }

    @Override
    public boolean updateStatusById(UserCarEntity userCarEntity) {
        UserCarEntity userCar = userCarDAO.findById(userCarEntity.getId()).get();
        String status = userCarEntity.getStatus();
        if (status != null) {
            userCar.setStatus(status);
            userCar.setLastUpdatedBy(userCarEntity.getLastUpdatedBy());
            userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
            userCarDAO.save(userCar);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(UserCarEntity userCarEntity) {
        UserCarEntity userCar = userCarDAO.findById(userCarEntity.getId()).get();
        String remark = userCarEntity.getRemark();
        if (remark != null) {
            userCar.setRemark(remark);
            userCar.setLastUpdatedBy(userCarEntity.getLastUpdatedBy());
            userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
            userCarDAO.save(userCar);
            return true;
        }
        return false;
    }

    @Override
    public UserCarEntity searchUserCarById(UserCarEntity userCarEntity) {
        return userCarDAO.findById(userCarEntity.getId()).get();
    }

    @Override
    public List<UserCarEntity> searchUserCarByUserId(UserCarEntity userCarEntity) {
        return userCarDAO.findByUserId(userCarEntity.getUserId());
    }

    @Override
    public List<UserCarEntity> searchUserCarByUsername(UserCarEntity userCarEntity) {
        return userCarDAO.findByUsername(userCarEntity.getUsername());
    }

    @Override
    public List<UserCarEntity> searchUserCarByCarId(UserCarEntity userCarEntity) {
        return userCarDAO.findByCarId(userCarEntity.getCarId());
    }

    @Override
    public List<UserCarEntity> searchUserCarByCarName(UserCarEntity userCarEntity) {
        return userCarDAO.findByCarName(userCarEntity.getCarName());
    }

    @Override
    public Page<UserCarEntity> searchAllUserCar(Integer pageIndex, Integer pageSize) {
        return userCarDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
