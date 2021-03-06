package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserEntity, Integer> {

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);

    UserEntity findByPhone(String phone);

    UserEntity findByEmail(String email);

    Page<UserEntity> findByIsActivated(String active, Pageable pageable);

    Page<UserEntity> findAll(Pageable pageable);

}

