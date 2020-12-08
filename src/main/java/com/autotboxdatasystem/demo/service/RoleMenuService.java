package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleMenuService {
    boolean addMenu2Role(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByRoleId(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByRoleName(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByMenuId(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByMenuName(RoleMenuEntity roleMenuEntity);

    RoleMenuEntity searchRoleMenuById(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByRoleId(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByRoleName(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByMenuId(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByMenuName(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchAllRoleMenu(Integer pageIndex, Integer pageSize);
}
