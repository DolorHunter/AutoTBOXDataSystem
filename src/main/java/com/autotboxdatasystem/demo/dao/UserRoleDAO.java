package com.autotboxdatasystem.demo.dao;

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

    Page<UserRoleEntity> findByUserId(Integer userId, Pageable pageable);

    Page<UserRoleEntity> findByUsername(String username, Pageable pageable);

    List<UserRoleEntity> findByRoleId(Integer roleId);

    Page<UserRoleEntity> findByRoleId(Integer roleId, Pageable pageable);

    Page<UserRoleEntity> findByRoleName(String roleName, Pageable pageable);

    UserRoleEntity findByUserIdAndRoleId(Integer userId, Integer roleId);

    UserRoleEntity findByUsernameAndRoleName(String username, String roleName);

    Page<UserRoleEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserRoleEntity> findAll(Pageable pageable);
}
