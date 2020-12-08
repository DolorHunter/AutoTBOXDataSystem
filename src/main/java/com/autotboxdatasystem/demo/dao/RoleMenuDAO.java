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

    List<RoleMenuEntity> findByRoleName(String roleName);

    List<RoleMenuEntity> findByMenuId(Integer menuId);

    List<RoleMenuEntity> findByMenuName(String menuName);

    RoleMenuEntity findByRoleIdAndMenuId(Integer roleId, Integer menuId);

    RoleMenuEntity findByRoleNameAndMenuName(String roleName, String menuName);

    List<RoleMenuEntity> findByCreatedBy(String username);

    List<RoleMenuEntity> findByLastUpdatedBy(String username);

    Page<RoleMenuEntity> findByIsActivated(String active, Pageable pageable);

    Page<RoleMenuEntity> findAll(Pageable pageable);
}
