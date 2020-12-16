package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserRoleEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserRoleService {
    boolean addRole2User(UserRoleEntity userRoleEntity);

    void deleteUserRoleByUserId(UserRoleEntity userRoleEntity);

    void deleteUserRoleByUsername(UserRoleEntity userRoleEntity);

    void deleteUserRoleByRoleId(UserRoleEntity userRoleEntity);

    void deleteUserRoleByRoleName(UserRoleEntity userRoleEntity);

    boolean updateStatusById(UserRoleEntity userRoleEntity);

    boolean updateRemarkById(UserRoleEntity userRoleEntity);

    UserRoleEntity searchUserRoleById(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByUserId(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByUsername(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByRoleId(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByRoleName(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchAllUserRole(Integer pageIndex, Integer pageSize);
}
