package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.VisualChartEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisualChartDAO extends PagingAndSortingRepository<VisualChartEntity, Integer> {

    void deleteByChartName(String chartName);

    VisualChartEntity findByChartName(String chartName);

    Page<VisualChartEntity> findByChartType(String chartName, Pageable pageable);
}
