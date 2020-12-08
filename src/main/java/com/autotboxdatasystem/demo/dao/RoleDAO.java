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

    List<RoleEntity> findByCreatedBy(String username);

    List<RoleEntity> findByLastUpdatedBy(String username);

    Page<RoleEntity> findByIsActivated(String active, Pageable pageable);

    Page<RoleEntity> findAll(Pageable pageable);
}
