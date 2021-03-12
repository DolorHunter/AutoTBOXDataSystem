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

    boolean updateStatusById(RoleMenuEntity roleMenuEntity);

    boolean updateRemarkById(RoleMenuEntity roleMenuEntity);

    RoleMenuEntity searchRoleMenuById(RoleMenuEntity roleMenuEntity);
    List<RoleMenuEntity> searchRoleMenuByRoleIdList(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByRoleIdPager(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByRoleNameList(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByRoleNamePager(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByMenuIdList(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByMenuIdPager(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchRoleMenuByMenuNameList(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchRoleMenuByMenuNamePager(RoleMenuEntity roleMenuEntity);

    List<RoleMenuEntity> searchAllRoleMenuList(RoleMenuEntity roleMenuEntity);

    Page<RoleMenuEntity> searchAllRoleMenuPager(RoleMenuEntity roleMenuEntity);
}
