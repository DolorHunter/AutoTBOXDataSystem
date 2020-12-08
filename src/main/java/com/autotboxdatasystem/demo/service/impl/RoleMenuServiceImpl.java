package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.RoleMenuDAO;
import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import com.autotboxdatasystem.demo.service.RoleMenuService;
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
public class RoleMenuServiceImpl implements RoleMenuService {
    private final RoleMenuDAO roleMenuDAO;

    @Autowired
    public RoleMenuServiceImpl(RoleMenuDAO roleMenuDAO) {
        this.roleMenuDAO = roleMenuDAO;
    }

    @Override
    public boolean addMenu2Role(RoleMenuEntity roleMenuEntity) {
        RoleMenuEntity roleMenu = roleMenuDAO.findByRoleIdAndMenuId(roleMenuEntity.getRoleId(), roleMenuEntity.getMenuId());
        if (roleMenu != null) {
            return false;
        }

        roleMenuEntity.setIsActivated("1");
        roleMenuEntity.setIsDeleted("0");

        roleMenuEntity.setCreatedDate(DateUtil.getCurDateTime());
        roleMenuEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        roleMenuDAO.save(roleMenuEntity);
        return true;
    }

    @Override
    public void deleteRoleMenuByRoleId(RoleMenuEntity roleMenuEntity) {
        roleMenuDAO.deleteAllByRoleId(roleMenuEntity.getRoleId());
    }

    @Override
    public void deleteRoleMenuByRoleName(RoleMenuEntity roleMenuEntity) {
        roleMenuDAO.deleteAllByRoleName(roleMenuEntity.getRoleName());
    }

    @Override
    public void deleteRoleMenuByMenuId(RoleMenuEntity roleMenuEntity) {
        roleMenuDAO.deleteAllByMenuId(roleMenuEntity.getMenuId());
    }

    @Override
    public void deleteRoleMenuByMenuName(RoleMenuEntity roleMenuEntity) {
        roleMenuDAO.deleteAllByMenuName(roleMenuEntity.getMenuName());
    }

    @Override
    public RoleMenuEntity searchRoleMenuById(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findById(roleMenuEntity.getId()).get();
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByRoleId(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByRoleId(roleMenuEntity.getRoleId());
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByRoleName(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByRoleName(roleMenuEntity.getRoleName());
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByMenuId(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByMenuId(roleMenuEntity.getMenuId());
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByMenuName(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByMenuName(roleMenuEntity.getMenuName());
    }

    @Override
    public Page<RoleMenuEntity> searchAllRoleMenu(Integer pageIndex, Integer pageSize) {
        return roleMenuDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
