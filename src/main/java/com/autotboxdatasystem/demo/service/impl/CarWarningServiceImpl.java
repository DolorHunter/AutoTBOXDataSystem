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
        // 重复数据不添加
        CarWarningEntity carWarning = searchExistCarWarningByVinAndSendingTimeAndErrorContentAndFaultCategory(carWarningEntity);
        if (carWarning != null){
            return false;
        }

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
    public void deleteCarWarningByVin(CarWarningEntity carWarningEntity) {
        carWarningDAO.deleteAllByVin(carWarningEntity.getVin());
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
            carWarning.setRemark(remark);
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
    public List<CarWarningEntity> searchCarWarningByVinList(CarWarningEntity carWarningEntity) {
        String vin = carWarningEntity.getVin();
        return carWarningDAO.findByVin(vin);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningByVinPager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        String vin = carWarningEntity.getVin();
        return carWarningDAO.findByVin(vin, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningEntity> searchCarWarningByErrorContentList(CarWarningEntity carWarningEntity) {
        String carName = carWarningEntity.getErrorContent();
        return carWarningDAO.findByErrorContent(carName);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningByErrorContentPager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        String errorContent = carWarningEntity.getErrorContent();
        return carWarningDAO.findByErrorContent(errorContent, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningEntity> searchCarWarningByFaultCategoryList(CarWarningEntity carWarningEntity) {
        String warUnit = carWarningEntity.getFaultCategory();
        return carWarningDAO.findByFaultCategory(warUnit);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningByFaultCategoryPager(CarWarningEntity carWarningEntity) {
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        String faultCategory = carWarningEntity.getFaultCategory();
        return carWarningDAO.findByFaultCategory(faultCategory, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<CarWarningEntity> searchCarWarningBySendingTimeBetweenList(CarWarningEntity carWarningEntity) {
        String time1 = carWarningEntity.getSendingTime();
        String time2 = carWarningEntity.getRemark();
        return carWarningDAO.findBySendingTimeBetween(time1, time2);
    }

    @Override
    public Page<CarWarningEntity> searchCarWarningBySendingTimeBetweenPager(CarWarningEntity carWarningEntity) {
        String time1 = carWarningEntity.getSendingTime();
        String time2 = carWarningEntity.getRemark();
        Integer pageIndex = carWarningEntity.getPageIndex();
        Integer pageSize = carWarningEntity.getPageSize();
        return carWarningDAO.findBySendingTimeBetween(time1, time2, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<Object> searchCarWarningDetailBySendingTimeBetween(CarWarningEntity carWarningEntity) {
        String time1 = carWarningEntity.getSendingTime();
        String time2 = carWarningEntity.getRemark();
        return carWarningDAO.findCarWarningDetailBySendingTimeBetween(time1, time2);
    }

    @Override
    public List<Object> searchUserCarWarningDetailBySendingTimeBetween(CarWarningEntity carWarningEntity) {
        String time1 = carWarningEntity.getSendingTime();
        String time2 = carWarningEntity.getRemark();
        return carWarningDAO.findUserCarWarningDetailBySendingTimeBetween(time1, time2);
    }

    @Override
    public CarWarningEntity searchExistCarWarningByVinAndSendingTimeAndErrorContentAndFaultCategory(CarWarningEntity carWarningEntity) {
        String vin = carWarningEntity.getVin();
        String sendingTime = carWarningEntity.getSendingTime();
        String errorContent = carWarningEntity.getErrorContent();
        String faultCategory = carWarningEntity.getFaultCategory();
        return carWarningDAO.findByVinAndSendingTimeAndErrorContentAndFaultCategory(vin, sendingTime, errorContent, faultCategory);
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
