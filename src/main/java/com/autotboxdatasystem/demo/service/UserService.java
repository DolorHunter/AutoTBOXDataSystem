package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.UserEntity;
import org.springframework.data.domain.Page;

public interface UserService {
    String addUser(UserEntity userEntity);

    void activateUserById(UserEntity userEntity);

    void deactivateUserById(UserEntity userEntity);

    void softDeleteUserById(UserEntity userEntity);

    void restoreUserById(UserEntity userEntity);

    void hardDeleteUserById(UserEntity userEntity);

    boolean updateUsernameById(UserEntity userEntity);

    boolean updateEmailById(UserEntity userEntity);

    boolean updatePhoneById(UserEntity userEntity);

    boolean updatePasswordById(UserEntity userEntity);

    boolean updateAvatarById(UserEntity userEntity);

    void resetPasswordById(UserEntity userEntity);

    UserEntity searchUserByUsername(UserEntity userEntity);

    UserEntity searchUserById(UserEntity userEntity);

    Page<UserEntity> searchActivedUser(Integer pageIndex, Integer pageSize);

    Page<UserEntity> searchAllUser(Integer pageIndex, Integer pageSize);

}
