package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.VisualChartEntity;
import org.springframework.data.domain.Page;

public interface VisualChartService {
    boolean addVisualChart(VisualChartEntity visualChartEntity);

    void deleteVisualChartById(VisualChartEntity visualChartEntity);

    void deleteVisualChartByChartName(VisualChartEntity visualChartEntity);

    boolean updateStatusById(VisualChartEntity visualChartEntity);

    boolean updateRemarkById(VisualChartEntity visualChartEntity);

    VisualChartEntity searchVisualChartById(VisualChartEntity visualChartEntity);

    VisualChartEntity searchVisualChartByChartName(VisualChartEntity visualChartEntity);

    Page<VisualChartEntity> searchAllVisualChart(VisualChartEntity visualChartEntity);
}
