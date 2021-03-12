package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.VisualChartDAO;
import com.autotboxdatasystem.demo.entity.CarWarrantyEntity;
import com.autotboxdatasystem.demo.entity.VisualChartEntity;
import com.autotboxdatasystem.demo.service.VisualChartService;
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
public class VisualChartServiceImpl implements VisualChartService{
    private final VisualChartDAO visualChartDAO;

    @Autowired
    public VisualChartServiceImpl(VisualChartDAO visualChartDAO) {
        this.visualChartDAO = visualChartDAO;
    }

    @Override
    public boolean addVisualChart(VisualChartEntity visualChartEntity) {
        VisualChartEntity visualChart = visualChartDAO.findByChartName(visualChartEntity.getchartName());
        if (visualChart != null){
            return false;
        }

        visualChartEntity.setIsActivated("1");
        visualChartEntity.setIsDeleted("0");

        visualChartEntity.setCreatedDate(DateUtil.getCurDateTime());
        visualChartEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        visualChartDAO.save(visualChartEntity);
        return true;
    }

    @Override
    public void deleteVisualChartById(VisualChartEntity visualChartEntity) {
        visualChartDAO.deleteById(visualChartEntity.getId());
    }

    @Override
    public void deleteVisualChartByChartName(VisualChartEntity visualChartEntity) {
        visualChartDAO.deleteByChartName(visualChartEntity.getchartName());
    }

    @Override
    public boolean updateStatusById(VisualChartEntity visualChartEntity) {
        VisualChartEntity visualChart = visualChartDAO.findById(visualChartEntity.getId()).get();
        String status = visualChartEntity.getStatus();
        if (status != null) {
            visualChart.setStatus(status);
            visualChart.setLastUpdatedBy(visualChartEntity.getLastUpdatedBy());
            visualChart.setLastUpdatedDate(DateUtil.getCurDateTime());
            visualChartDAO.save(visualChart);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(VisualChartEntity visualChartEntity) {
        VisualChartEntity visualChart = visualChartDAO.findById(visualChartEntity.getId()).get();
        String remark = visualChartEntity.getRemark();
        if (remark != null) {
            visualChart.setStatus(remark);
            visualChart.setLastUpdatedBy(visualChartEntity.getLastUpdatedBy());
            visualChart.setLastUpdatedDate(DateUtil.getCurDateTime());
            visualChartDAO.save(visualChart);
            return true;
        }
        return false;
    }

    @Override
    public VisualChartEntity searchVisualChartById(VisualChartEntity visualChartEntity) {
        return visualChartDAO.findById(visualChartEntity.getId()).get();
    }

    @Override
    public VisualChartEntity searchVisualChartByChartName(VisualChartEntity visualChartEntity) {
        return visualChartDAO.findByChartName(visualChartEntity.getchartName());
    }

    @Override
    public List<VisualChartEntity> searchAllVisualChartList(VisualChartEntity visualChartEntity) {
        return visualChartDAO.findAll();
    }

    @Override
    public Page<VisualChartEntity> searchAllVisualChartPager(VisualChartEntity visualChartEntity) {
        Integer pageIndex = visualChartEntity.getPageIndex();
        Integer pageSize = visualChartEntity.getPageSize();
        return visualChartDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
