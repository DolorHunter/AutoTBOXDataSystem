package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import org.springframework.data.domain.Page;

public interface RoleMenuService {
    boolean addMenu2Role(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByRoleId(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByRoleName(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByMenuId(RoleMenuEntity roleMenuEntity);

    void deleteRoleMenuByMenuName(RoleMenuEntity roleMenuEntity);

    boolean updateStatusById(RoleMenuEntity roleMenuEntity);

    boolean updateRemarkById(RoleMenuEntity roleMenuEntity);

    RoleMenuEntity searchRoleMenuById(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByRoleId(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByRoleName(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByMenuId(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByMenuName(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchAllRoleMenu(RoleMenuEntity roleMenuEntity);
}
