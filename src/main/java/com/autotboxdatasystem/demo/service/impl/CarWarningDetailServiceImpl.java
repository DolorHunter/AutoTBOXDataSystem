package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.CarWarningDetailDAO;
import com.autotboxdatasystem.demo.entity.CarWarningDetailEntity;
import com.autotboxdatasystem.demo.service.CarWarningDetailService;
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
public class CarWarningDetailServiceImpl implements CarWarningDetailService {
    private final CarWarningDetailDAO carWarningDetailDAO;

    @Autowired
    public CarWarningDetailServiceImpl(CarWarningDetailDAO carWarningDetailDAO){
        this.carWarningDetailDAO = carWarningDetailDAO;
    }

    @Override
    public boolean addCarWarningDetail(CarWarningDetailEntity carWarningDetailEntity) {
        // 重复数据不添加
        CarWarningDetailEntity carWarningDetail = searchCarWarningDetailByCarTypeAndErrorContent(carWarningDetailEntity);
        if (carWarningDetail != null){
            return false;
        }

        carWarningDetailEntity.setIsActivated("1");
        carWarningDetailEntity.setIsDeleted("0");

        carWarningDetailEntity.setCreatedDate(DateUtil.getCurDateTime());
        carWarningDetailEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        carWarningDetailDAO.save(carWarningDetailEntity);
        return true;
    }

    @Override
    public void deleteCarWarningDetailById(CarWarningDetailEntity carWarningDetailEntity) {
        carWarningDetailDAO.deleteById(carWarningDetailEntity.getId());
    }

    @Override
    public void deleteCarWarningDetailByCarType(CarWarningDetailEntity carWarningDetailEntity) {
        carWarningDetailDAO.deleteAllByCarType(carWarningDetailEntity.getCarType());
    }

    @Override
    public boolean updateStatusById(CarWarningDetailEntity carWarningDetailEntity) {
        CarWarningDetailEntity carWarningDetail = carWarningDetailDAO.findById(carWarningDetailEntity.getId()).get();
        String status = carWarningDetailEntity.getStatus();
        if (status != null) {
            carWarningDetail.setStatus(status);
            carWarningDetail.setLastUpdatedBy(carWarningDetailEntity.getLastUpdatedBy());
            carWarningDetail.setLastUpdatedDate(DateUtil.getCurDateTime());
            carWarningDetailDAO.save(carWarningDetail);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(CarWarningDetailEntity carWarningDetailEntity) {
        CarWarningDetailEntity carWarningDetail = carWarningDetailDAO.findById(carWarningDetailEntity.getId()).get();
        String remark = carWarningDetailEntity.getRemark();
        if (remark != null) {
            carWarningDetail.setRemark(remark);
            carWarningDetail.setLastUpdatedBy(carWarningDetailEntity.getLastUpdatedBy());
            carWarningDetail.setLastUpdatedDate(DateUtil.getCurDateTime());
            carWarningDetailDAO.save(carWarningDetail);
            return true;
        }
        return false;
    }

    @Override
    public CarWarningDetailEntity searchCarWarningDetailById(CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailDAO.findById(carWarningDetailEntity.getId()).get();
    }

    @Override
    public CarWarningDetailEntity searchCarWarningDetailByCarTypeAndErrorContent(CarWarningDetailEntity carWarningDetailEntity) {
        String carType = carWarningDetailEntity.getCarType();
        String errorContent = carWarningDetailEntity.getErrorContent();
        return carWarningDetailDAO.findByCarTypeAndErrorContent(carType, errorContent);
    }

    @Override
    public List<CarWarningDetailEntity> searchCarWarningDetailByCarTypeList(CarWarningDetailEntity carWarningDetailEntity) {
        String carType = carWarningDetailEntity.getCarType();
        return carWarningDetailDAO.findByCarType(carType);
    }

    @Override
    public Page<CarWarningDetailEntity> searchCarWarningDetailByCarTypePager(CarWarningDetailEntity carWarningDetailEntity) {
        Integer pageIndex = carWarningDetailEntity.getPageIndex();
        Integer pageSize = carWarningDetailEntity.getPageSize();
        String carType = carWarningDetailEntity.getCarType();
        return carWarningDetailDAO.findByCarType(carType, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningDetailEntity> searchAllCarWarningDetailList(CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailDAO.findAll();
    }

    @Override
    public Page<CarWarningDetailEntity> searchAllCarWarningDetailPager(CarWarningDetailEntity carWarningDetailEntity) {
        Integer pageIndex = carWarningDetailEntity.getPageIndex();
        Integer pageSize = carWarningDetailEntity.getPageSize();
        return carWarningDetailDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
