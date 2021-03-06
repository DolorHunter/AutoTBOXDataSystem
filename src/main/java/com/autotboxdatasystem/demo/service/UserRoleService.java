package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserRoleEntity;
import org.springframework.data.domain.Page;

public interface UserRoleService {
    boolean addRole2User(UserRoleEntity userRoleEntity);

    void deleteUserRoleByUserId(UserRoleEntity userRoleEntity);

    void deleteUserRoleByUsername(UserRoleEntity userRoleEntity);

    void deleteUserRoleByRoleId(UserRoleEntity userRoleEntity);

    void deleteUserRoleByRoleName(UserRoleEntity userRoleEntity);

    boolean updateStatusById(UserRoleEntity userRoleEntity);

    boolean updateRemarkById(UserRoleEntity userRoleEntity);

    UserRoleEntity searchUserRoleById(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByUserId(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByUsername(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByRoleId(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByRoleName(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchAllUserRole(UserRoleEntity userRoleEntity);
}
