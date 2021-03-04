package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.UserCarWarrantyDAO;
import com.autotboxdatasystem.demo.entity.UserCarWarrantyEntity;
import com.autotboxdatasystem.demo.service.UserCarWarrantyService;
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
public class UserCarWarrantyServiceImpl implements UserCarWarrantyService {
    private final UserCarWarrantyDAO userCarWarrantyDAO;

    @Autowired
    public UserCarWarrantyServiceImpl(UserCarWarrantyDAO userCarWarrantyDAO) {
        this.userCarWarrantyDAO = userCarWarrantyDAO;
    }

    @Override
    public boolean addUserCarWarranty(UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyEntity.setIsActivated("1");
        userCarWarrantyEntity.setIsDeleted("0");

        userCarWarrantyEntity.setCreatedDate(DateUtil.getCurDateTime());
        userCarWarrantyEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userCarWarrantyDAO.save(userCarWarrantyEntity);
        return true;
    }

    @Override
    public void deleteUserCarWarrantyById(UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyDAO.deleteById(userCarWarrantyEntity.getId());
    }

    @Override
    public void deleteUserCarWarrantyByUserCarId(UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyDAO.deleteAllByUserCarId(userCarWarrantyEntity.getUserCarId());
    }

    @Override
    public boolean updateStatusById(UserCarWarrantyEntity userCarWarrantyEntity) {
        UserCarWarrantyEntity userCarWarranty = userCarWarrantyDAO.findById(userCarWarrantyEntity.getId()).get();
        String status = userCarWarrantyEntity.getStatus();
        if (status != null) {
            userCarWarranty.setStatus(status);
            userCarWarranty.setLastUpdatedBy(userCarWarrantyEntity.getLastUpdatedBy());
            userCarWarranty.setLastUpdatedDate(DateUtil.getCurDateTime());
            userCarWarrantyDAO.save(userCarWarranty);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(UserCarWarrantyEntity userCarWarrantyEntity) {
        UserCarWarrantyEntity userCarWarranty = userCarWarrantyDAO.findById(userCarWarrantyEntity.getId()).get();
        String remark = userCarWarrantyEntity.getRemark();
        if (remark != null) {
            userCarWarranty.setStatus(remark);
            userCarWarranty.setLastUpdatedBy(userCarWarrantyEntity.getLastUpdatedBy());
            userCarWarranty.setLastUpdatedDate(DateUtil.getCurDateTime());
            userCarWarrantyDAO.save(userCarWarranty);
            return true;
        }
        return false;
    }

    @Override
    public UserCarWarrantyEntity searchUserCarWarrantyById(UserCarWarrantyEntity userCarWarrantyEntity) {
        return userCarWarrantyDAO.findById(userCarWarrantyEntity.getId()).get();
    }

    @Override
    public List<UserCarWarrantyEntity> searchUserCarWarrantyByUserCarId(UserCarWarrantyEntity userCarWarrantyEntity) {
        return userCarWarrantyDAO.findByUserCarId(userCarWarrantyEntity.getUserCarId());
    }

    @Override
    public Page<UserCarWarrantyEntity> searchAllUserCarWarranty(Integer pageIndex, Integer pageSize) {
        return userCarWarrantyDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
