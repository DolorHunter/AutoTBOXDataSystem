package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.UserCarLogDAO;
import com.autotboxdatasystem.demo.entity.UserCarLogEntity;
import com.autotboxdatasystem.demo.service.UserCarLogService;
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
public class UserCarLogServiceImpl implements UserCarLogService{
    private final UserCarLogDAO userCarLogDAO;

    @Autowired
    public UserCarLogServiceImpl(UserCarLogDAO userCarLogDAO) {
        this.userCarLogDAO = userCarLogDAO;
    }

    @Override
    public boolean addUserCarLog(UserCarLogEntity userCarLogEntity) {
        userCarLogEntity.setIsActivated("1");
        userCarLogEntity.setIsDeleted("0");

        userCarLogEntity.setCreatedDate(DateUtil.getCurDateTime());
        userCarLogEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userCarLogDAO.save(userCarLogEntity);
        return true;
    }

    @Override
    public void deleteUserCarLogById(UserCarLogEntity userCarLogEntity) {
        userCarLogDAO.deleteById(userCarLogEntity.getId());
    }

    @Override
    public void deleteUserCarLogByUserCarId(UserCarLogEntity userCarLogEntity) {
        userCarLogDAO.deleteAllByUserCarId(userCarLogEntity.getUserCarId());
    }

    @Override
    public boolean updateStatusById(UserCarLogEntity userCarLogEntity) {
        UserCarLogEntity userCarLog = userCarLogDAO.findById(userCarLogEntity.getId()).get();
        String status = userCarLogEntity.getStatus();
        if (status != null) {
            userCarLog.setStatus(status);
            userCarLog.setLastUpdatedBy(userCarLogEntity.getLastUpdatedBy());
            userCarLog.setLastUpdatedDate(DateUtil.getCurDateTime());
            userCarLogDAO.save(userCarLog);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(UserCarLogEntity userCarLogEntity) {
        UserCarLogEntity userCarLog = userCarLogDAO.findById(userCarLogEntity.getId()).get();
        String remark = userCarLogEntity.getRemark();
        if (remark != null) {
            userCarLog.setRemark(remark);
            userCarLog.setLastUpdatedBy(userCarLogEntity.getLastUpdatedBy());
            userCarLog.setLastUpdatedDate(DateUtil.getCurDateTime());
            userCarLogDAO.save(userCarLog);
            return true;
        }
        return false;
    }

    @Override
    public UserCarLogEntity searchUserCarLogById(UserCarLogEntity userCarLogEntity) {
        return userCarLogDAO.findById(userCarLogEntity.getId()).get();
    }

    @Override
    public List<UserCarLogEntity> searchUserCarLogByUserCarId(UserCarLogEntity userCarLogEntity) {
        return userCarLogDAO.findByUserCarId(userCarLogEntity.getUserCarId());
    }

    @Override
    public Page<UserCarLogEntity> searchAllUserCarLog(Integer pageIndex, Integer pageSize) {
        return userCarLogDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
