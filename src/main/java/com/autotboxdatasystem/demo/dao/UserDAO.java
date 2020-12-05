package com.autotboxdatasystem.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.autotboxdatasystem.demo.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserEntity, Integer> {

    UserEntity findByPhone(String username);

    UserEntity findByEmail(String email);

    Page<UserEntity> findAll(Pageable pageable);

}

