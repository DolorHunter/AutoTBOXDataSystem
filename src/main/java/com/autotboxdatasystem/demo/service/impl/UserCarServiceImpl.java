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
    public void deleteUserCarById(UserCarEntity userCarEntity) {
        userCarDAO.deleteById(userCarEntity.getId());
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
    public Page<UserCarEntity> searchUserCarByUserId(UserCarEntity userCarEntity) {
        Integer pageIndex = userCarEntity.getPageIndex();
        Integer pageSize = userCarEntity.getPageSize();
        Integer userId = userCarEntity.getUserId();
        return userCarDAO.findByUserId(userId, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserCarEntity> searchUserCarByUsername(UserCarEntity userCarEntity) {
        Integer pageIndex = userCarEntity.getPageIndex();
        Integer pageSize = userCarEntity.getPageSize();
        String username = userCarEntity.getUsername();
        return userCarDAO.findByUsername(username, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserCarEntity> searchUserCarByCarId(UserCarEntity userCarEntity) {
        Integer pageIndex = userCarEntity.getPageIndex();
        Integer pageSize = userCarEntity.getPageSize();
        Integer carId = userCarEntity.getCarId();
        return userCarDAO.findByCarId(carId, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserCarEntity> searchUserCarByCarName(UserCarEntity userCarEntity) {
        Integer pageIndex = userCarEntity.getPageIndex();
        Integer pageSize = userCarEntity.getPageSize();
        String carName = userCarEntity.getCarName();
        return userCarDAO.findByCarName(carName, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserCarEntity> searchAllUserCar(UserCarEntity userCarEntity) {
        Integer pageIndex = userCarEntity.getPageIndex();
        Integer pageSize = userCarEntity.getPageSize();
        return userCarDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
