package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import com.autotboxdatasystem.demo.entity.UserRoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends PagingAndSortingRepository<UserRoleEntity, Integer> {

    void deleteAllByUserId(Integer userId);

    void deleteAllByUsername(String username);

    void deleteAllByRoleId(Integer roleId);

    void deleteAllByRoleName(String roleName);

    List<UserRoleEntity> findByUserId(Integer userId);

    List<UserRoleEntity> findByUsername(String username);

    List<UserRoleEntity> findByRoleId(Integer roleId);

    List<UserRoleEntity> findByRoleName(String roleName);

    UserRoleEntity findByUserIdAndRoleId(Integer userId, Integer roleId);

    UserRoleEntity findByUsernameAndRoleName(String username, String roleName);

    List<UserRoleEntity> findByCreatedBy(String username);

    List<UserRoleEntity> findByLastUpdatedBy(String username);

    Page<UserRoleEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserRoleEntity> findAll(Pageable pageable);

}
