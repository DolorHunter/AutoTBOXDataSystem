package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserEntity;
import org.springframework.data.domain.Page;

public interface UserService {
    boolean login(UserEntity userEntity);

    String addUser(UserEntity userEntity);

    void activateUserById(UserEntity userEntity);

    void deactivateUserById(UserEntity userEntity);

    void softDeleteUserById(UserEntity userEntity);

    void restoreUserById(UserEntity userEntity);

    void hardDeleteUserById(UserEntity userEntity);

    boolean updateStatusById(UserEntity userEntity);

    boolean updateRemarkById(UserEntity userEntity);

    boolean updateEmailById(UserEntity userEntity);

    boolean updatePhoneById(UserEntity userEntity);

    boolean updatePasswordById(UserEntity userEntity);

    boolean updateAvatarById(UserEntity userEntity);

    void resetPasswordById(UserEntity userEntity);

    UserEntity searchUserByUsername(UserEntity userEntity);

    UserEntity searchUserById(UserEntity userEntity);

    Page<UserEntity> searchActivedUser(UserEntity userEntity);

    Page<UserEntity> searchAllUser(UserEntity userEntity);

}
