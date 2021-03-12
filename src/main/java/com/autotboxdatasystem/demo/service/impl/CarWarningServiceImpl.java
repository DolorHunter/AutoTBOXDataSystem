package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.CarWarningDAO;
import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import com.autotboxdatasystem.demo.service.CarWarningService;
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
public class CarWarningServiceImpl implements CarWarningService {
    private final CarWarningDAO carWarningDAO;

    @Autowired
    public CarWarningServiceImpl(CarWarningDAO carWarningDAO) {
        this.carWarningDAO = carWarningDAO;
    }

    @Override
    public boolean addCarWarning(CarWarningEntity carWarningEntity) {
        carWarningEntity.setIsActivated("1");
        carWarningEntity.setIsDeleted("0");

        carWarningEntity.setCreatedDate(DateUtil.getCurDateTime());
        carWarningEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        carWarningDAO.save(carWarningEntity);
        return true;
    }

    @Override
    public void deleteCarWarningById(CarWarningEntity carWarningEntity) {
        carWarningDAO.deleteById(carWarningEntity.getId());
    }

    @Override
    public void deleteCarWarningByVIN(CarWarningEntity carWarningEntity) {
        carWarningDAO.deleteAllByVIN(carWarningEntity.getVIN());
    }

    @Override
    public boolean updateStatusById(CarWarningEntity carWarningEntity) {
        CarWarningEntity carWarning = carWarningDAO.findById(carWarningEntity.getId()).get();
        String status = carWarningEntity.getStatus();
        if (status != null) {
            carWarning.setStatus(status);
            carWarning.setLastUpdatedBy(carWarningEntity.getLastUpdatedBy());
            carWarning.setLastUpdatedDate(DateUtil.getCurDateTime());
            carWarningDAO.save(carWarning);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(CarWarningEntity carWarningEntity) {
        CarWarningEntity carWarning = carWarningDAO.findById(carWarningEntity.getId()).get();
        String remark = carWarningEntity.getRemark();
        if (remark != null) {
            carWarning.setStatus(remark);
            carWarning.setLastUpdatedBy(carWarningEntity.getLastUpdatedBy());
            carWarning.setLastUpdatedDate(DateUtil.getCurDateTime());
            carWarningDAO.save(carWarning);
            return true;
        }
        return false;
    }

    @Override
    public CarWarningEntity searchCarWarningById(CarWarningEntity carWarningEntity) {
        return carWarningDAO.findById(carWarningEntity.getId()).get();
    }

    @Override
    public List<CarWarningEntity> searchCarWarningByVINList(CarWarningEntity carWarningEntity) {
        String VIN = carWarningEntity.getVIN();
        return carWarningDAO.findByVIN(VIN);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningByVINPager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        String VIN = carWarningEntity.getVIN();
        return carWarningDAO.findByVIN(VIN, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningEntity> searchCarWarningByCarNameList(CarWarningEntity carWarningEntity) {
        String carName = carWarningEntity.getCarName();
        return carWarningDAO.findByCarName(carName);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningByCarNamePager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        String carName = carWarningEntity.getCarName();
        return carWarningDAO.findByCarName(carName, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningEntity> searchCarWarningByUnitList(CarWarningEntity carWarningEntity) {
        String warUnit = carWarningEntity.getWarUnit();
        return carWarningDAO.findByWarUnit(warUnit);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningByUnitPager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        String warUnit = carWarningEntity.getWarUnit();
        return carWarningDAO.findByWarUnit(warUnit, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningEntity> searchAllCarWarningList(CarWarningEntity carWarningEntity) {
        return carWarningDAO.findAll();
    }

    @Override
    public Page<CarWarningEntity> searchAllCarWarningPager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        return carWarningDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
