package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.RoleEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {
    boolean addRole(RoleEntity roleEntity);

    void activateRoleById(RoleEntity roleEntity);

    void deactivateRoleById(RoleEntity roleEntity);

    void softDeleteRoleById(RoleEntity roleEntity);

    void restoreRoleById(RoleEntity roleEntity);

    void hardDeleteRoleById(RoleEntity roleEntity);

    boolean updateStatusById(RoleEntity roleEntity);

    boolean updateRemarkById(RoleEntity roleEntity);

    void updateRoleById(RoleEntity roleEntity);

    RoleEntity searchRoleById(RoleEntity roleEntity);

    RoleEntity searchRoleByRoleName(RoleEntity roleEntity);

    List<RoleEntity> searchActivedRoleList(RoleEntity roleEntity);

    Page<RoleEntity> searchActivedRolePager(RoleEntity roleEntity);

    List<RoleEntity> searchAllRoleList(RoleEntity roleEntity);

    Page<RoleEntity> searchAllRolePager(RoleEntity roleEntity);
}
