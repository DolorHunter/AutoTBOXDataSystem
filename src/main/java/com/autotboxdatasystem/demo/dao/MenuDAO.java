package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDAO extends PagingAndSortingRepository<MenuEntity, Integer> {

    MenuEntity findByMenuName(String menuName);

    List<MenuEntity> findByFatherMenuId(Integer fatherMenuId);

    List<MenuEntity> findByIsActivated(String active);

    Page<MenuEntity> findByIsActivated(String active, Pageable pageable);

    List<MenuEntity> findAll();

    Page<MenuEntity> findAll(Pageable pageable);
}
