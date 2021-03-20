package com.autotboxdatasystem.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class VisualChartEntity extends BaseEntity {
    @Column(nullable = false, columnDefinition = "varchar(255) comment '图表名'")
    private String chartName;
    @Column(nullable = false, columnDefinition = "varchar(8) comment '图表类型'")
    private String chartType;
    @Column(nullable = false, columnDefinition = "varchar(8192) comment '图表数据'")
    private String chartData;

    public String getchartName() {
        return chartName;
    }

    public void setchartName(String chartName) {
        this.chartName = chartName;
    }

    public String getchartType() {
        return chartType;
    }

    public void setchartType(String chartType) {
        this.chartType = chartType;
    }

    public String getchartData() {
        return chartData;
    }

    public void setchartData(String chartData) {
        this.chartData = chartData;
    }
}
