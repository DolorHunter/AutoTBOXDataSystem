package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.RoleEntity;
import org.springframework.data.domain.Page;

public interface RoleService {
    boolean addRole(RoleEntity roleEntity);

    void activateRoleById(RoleEntity roleEntity);

    void deactivateRoleById(RoleEntity roleEntity);

    void softDeleteRoleById(RoleEntity roleEntity);

    void restoreRoleById(RoleEntity roleEntity);

    void hardDeleteRoleById(RoleEntity roleEntity);

    void updateRoleById(RoleEntity roleEntity);

    RoleEntity searchRoleById(RoleEntity roleEntity);

    RoleEntity searchRoleByRoleName(RoleEntity roleEntity);

    Page<RoleEntity> searchActivedRole(Integer pageIndex, Integer pageSize);

    Page<RoleEntity> searchAllRole(Integer pageIndex, Integer pageSize);


}
