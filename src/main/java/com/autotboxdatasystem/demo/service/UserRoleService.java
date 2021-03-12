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

    List<UserRoleEntity> searchUserRoleByUserIdList(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByUserIdPager(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByUsernameList(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByUsernamePager(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByRoleIdList(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByRoleIdPager(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchUserRoleByRoleNameList(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchUserRoleByRoleNamePager(UserRoleEntity userRoleEntity);

    List<UserRoleEntity> searchAllUserRoleList(UserRoleEntity userRoleEntity);

    Page<UserRoleEntity> searchAllUserRolePager(UserRoleEntity userRoleEntity);
}
