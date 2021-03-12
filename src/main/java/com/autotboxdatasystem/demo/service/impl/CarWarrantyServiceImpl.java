package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.CarWarrantyDAO;
import com.autotboxdatasystem.demo.entity.CarWarrantyEntity;
import com.autotboxdatasystem.demo.service.CarWarrantyService;
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
public class CarWarrantyServiceImpl implements CarWarrantyService {
    private final CarWarrantyDAO carWarrantyDAO;

    @Autowired
    public CarWarrantyServiceImpl(CarWarrantyDAO carWarrantyDAO) {
        this.carWarrantyDAO = carWarrantyDAO;
    }

    @Override
    public boolean addCarWarranty(CarWarrantyEntity carWarrantyEntity) {
        carWarrantyEntity.setIsActivated("1");
        carWarrantyEntity.setIsDeleted("0");

        carWarrantyEntity.setCreatedDate(DateUtil.getCurDateTime());
        carWarrantyEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        carWarrantyDAO.save(carWarrantyEntity);
        return true;
    }

    @Override
    public void deleteCarWarrantyById(CarWarrantyEntity carWarrantyEntity) {
        carWarrantyDAO.deleteById(carWarrantyEntity.getId());
    }

    @Override
    public void deleteCarWarrantyByVIN(CarWarrantyEntity carWarrantyEntity) {
        carWarrantyDAO.deleteAllByVIN(carWarrantyEntity.getVIN());
    }

    @Override
    public boolean updateStatusById(CarWarrantyEntity carWarrantyEntity) {
        CarWarrantyEntity userCarWarranty = carWarrantyDAO.findById(carWarrantyEntity.getId()).get();
        String status = carWarrantyEntity.getStatus();
        if (status != null) {
            userCarWarranty.setStatus(status);
            userCarWarranty.setLastUpdatedBy(carWarrantyEntity.getLastUpdatedBy());
            userCarWarranty.setLastUpdatedDate(DateUtil.getCurDateTime());
            carWarrantyDAO.save(userCarWarranty);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(CarWarrantyEntity carWarrantyEntity) {
        CarWarrantyEntity userCarWarranty = carWarrantyDAO.findById(carWarrantyEntity.getId()).get();
        String remark = carWarrantyEntity.getRemark();
        if (remark != null) {
            userCarWarranty.setStatus(remark);
            userCarWarranty.setLastUpdatedBy(carWarrantyEntity.getLastUpdatedBy());
            userCarWarranty.setLastUpdatedDate(DateUtil.getCurDateTime());
            carWarrantyDAO.save(userCarWarranty);
            return true;
        }
        return false;
    }

    @Override
    public CarWarrantyEntity searchCarWarrantyById(CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyDAO.findById(carWarrantyEntity.getId()).get();
    }

    @Override
    public List<CarWarrantyEntity> searchCarWarrantyByVINList(CarWarrantyEntity carWarrantyEntity) {
        String VIN = carWarrantyEntity.getVIN();
        return carWarrantyDAO.findByVIN(VIN);
    }

    @Override
    public Page<CarWarrantyEntity> searchCarWarrantyByVINPager(CarWarrantyEntity carWarrantyEntity) {
        Integer pageIndex = carWarrantyEntity.getPageIndex();
        Integer pageSize = carWarrantyEntity.getPageSize();
        String VIN = carWarrantyEntity.getVIN();
        return carWarrantyDAO.findByVIN(VIN, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarrantyEntity> searchAllCarWarrantyList(CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyDAO.findAll();
    }

    @Override
    public Page<CarWarrantyEntity> searchAllCarWarrantyPager(CarWarrantyEntity carWarrantyEntity) {
        Integer pageIndex = carWarrantyEntity.getPageIndex();
        Integer pageSize = carWarrantyEntity.getPageSize();
        return carWarrantyDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
