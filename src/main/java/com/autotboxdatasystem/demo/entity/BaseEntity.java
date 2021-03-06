package com.autotboxdatasystem.demo.entity;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false, columnDefinition = "int comment 'ID'")
    private Integer id;
    @Column(nullable = false, columnDefinition = "varchar(4) comment '启用状态'")
    private String isActivated;
    @Column(nullable = false, columnDefinition = "varchar(4) comment '删除状态'")
    private String isDeleted;
    @Column(columnDefinition = "varchar(4) comment '状态'")
    private String status;
    @Column(columnDefinition = "varchar(64) comment '备注'")
    private String remark;
    @Column(nullable = false, columnDefinition = "varchar(32) comment '创建人'")
    private String createdBy;
    @Column(nullable = false, columnDefinition = "TIMESTAMP comment '创建时间'")
    private String createdDate;
    @Column(nullable = false, columnDefinition = "varchar(32) comment '最后修改人'")
    private String lastUpdatedBy;
    @Column(nullable = false, columnDefinition = "TIMESTAMP comment '最后修改日期'")
    private String lastUpdatedDate;
    @Transient
    private Integer pageIndex;
    @Transient
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(String isActivated) {
        this.isActivated = isActivated;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
