package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserEntity;
import org.springframework.data.domain.Page;

public interface UserService {

    boolean addUser(UserEntity userEntity);

    void activateUserById(UserEntity userEntity);

    void deactivateUserById(UserEntity userEntity);

    void softDeleteUserById(UserEntity userEntity);

    void restoreUserById(UserEntity userEntity);

    void hardDeleteUserById(UserEntity userEntity);

    void updateUserById(UserEntity userEntity);

    UserEntity searchUserById(UserEntity userEntity);

    Page<UserEntity> searchAllUser(Integer pageIndex, Integer pageSize);

}
