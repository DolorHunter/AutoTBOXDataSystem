package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

    UserEntity findByPhone(String phone);

    UserEntity findByEmail(String email);

    List<UserEntity> findByCreatedBy(String username);

    List<UserEntity> findByLastUpdatedBy(String username);

    Page<UserEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserEntity> findAll(Pageable pageable);

}

