package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.CarLogDAO;
import com.autotboxdatasystem.demo.entity.CarLogEntity;
import com.autotboxdatasystem.demo.service.CarLogService;
import com.autotboxdatasystem.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarLogServiceImpl implements CarLogService{
    private final CarLogDAO carLogDAO;

    @Autowired
    public CarLogServiceImpl(CarLogDAO carLogDAO) {
        this.carLogDAO = carLogDAO;
    }

    @Override
    public boolean addCarLog(CarLogEntity carLogEntity) {
        carLogEntity.setIsActivated("1");
        carLogEntity.setIsDeleted("0");

        carLogEntity.setCreatedDate(DateUtil.getCurDateTime());
        carLogEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        carLogDAO.save(carLogEntity);
        return true;
    }

    @Override
    public void deleteCarLogById(CarLogEntity carLogEntity) {
        carLogDAO.deleteById(carLogEntity.getId());
    }

    @Override
    public void deleteCarLogByVIN(CarLogEntity carLogEntity) {
        carLogDAO.deleteAllByVIN(carLogEntity.getVIN());
    }

    @Override
    public boolean updateStatusById(CarLogEntity carLogEntity) {
        CarLogEntity carLog = carLogDAO.findById(carLogEntity.getId()).get();
        String status = carLogEntity.getStatus();
        if (status != null) {
            carLog.setStatus(status);
            carLog.setLastUpdatedBy(carLogEntity.getLastUpdatedBy());
            carLog.setLastUpdatedDate(DateUtil.getCurDateTime());
            carLogDAO.save(carLog);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(CarLogEntity carLogEntity) {
        CarLogEntity carLog = carLogDAO.findById(carLogEntity.getId()).get();
        String remark = carLogEntity.getRemark();
        if (remark != null) {
            carLog.setRemark(remark);
            carLog.setLastUpdatedBy(carLogEntity.getLastUpdatedBy());
            carLog.setLastUpdatedDate(DateUtil.getCurDateTime());
            carLogDAO.save(carLog);
            return true;
        }
        return false;
    }

    @Override
    public CarLogEntity searchCarLogById(CarLogEntity carLogEntity) {
        return carLogDAO.findById(carLogEntity.getId()).get();
    }

    @Override
    public Page<CarLogEntity> searchCarLogByVIN(CarLogEntity carLogEntity) {
        Integer pageIndex = carLogEntity.getPageIndex();
        Integer pageSize = carLogEntity.getPageSize();
        String VIN = carLogEntity.getVIN();
        return carLogDAO.findByVIN(VIN, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<CarLogEntity> searchAllCarLog(CarLogEntity carLogEntity) {
        Integer pageIndex = carLogEntity.getPageIndex();
        Integer pageSize = carLogEntity.getPageSize();
        return carLogDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
