package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO extends PagingAndSortingRepository<RoleEntity, Integer> {

    RoleEntity findByRoleName(String roleName);

    List<RoleEntity> findByIsActivated(String active);

    Page<RoleEntity> findByIsActivated(String active, Pageable pageable);

    List<RoleEntity> findAll();

    Page<RoleEntity> findAll(Pageable pageable);
}
