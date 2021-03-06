package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuDAO extends PagingAndSortingRepository<RoleMenuEntity, Integer> {

    void deleteAllByRoleId(Integer roleId);

    void deleteAllByRoleName(String roleName);

    void deleteAllByMenuId(Integer menuId);

    void deleteAllByMenuName(String menuName);

    List<RoleMenuEntity> findByRoleId(Integer roleId);

    Page<RoleMenuEntity> findByRoleId(Integer roleId, Pageable pageable);

    List<RoleMenuEntity> findByRoleName(String roleName);

    Page<RoleMenuEntity> findByRoleName(String roleName, Pageable pageable);

    List<RoleMenuEntity> findByMenuId(Integer menuId);

    Page<RoleMenuEntity> findByMenuId(Integer menuId, Pageable pageable);

    List<RoleMenuEntity> findByMenuName(String menuName);

    Page<RoleMenuEntity> findByMenuName(String menuName, Pageable pageable);

    RoleMenuEntity findByRoleIdAndMenuId(Integer roleId, Integer menuId);

    RoleMenuEntity findByRoleNameAndMenuName(String roleName, String menuName);

    Page<RoleMenuEntity> findByIsActivated(String active, Pageable pageable);

    Page<RoleMenuEntity> findAll(Pageable pageable);
}
