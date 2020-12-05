package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.UserDAO;
import com.autotboxdatasystem.demo.entity.UserEntity;
import com.autotboxdatasystem.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.autotboxdatasystem.demo.util.DateUtil;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean addUser(UserEntity userEntity) {
        String phone = userEntity.getPhone();
        String email = userEntity.getEmail();

        if (userDAO.findByPhone(phone)!=null && userDAO.findByEmail(email)!=null){
            return false;
        }

        userEntity.setIsActivated("1");
        userEntity.setIsDeleted("0");

        String password = userEntity.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userEntity.setPassword(password);

        String username = userEntity.getUsername();
        userEntity.setCreatedBy(username);
        userEntity.setCreatedDate(DateUtil.getCurDateTime());
        userEntity.setLastUpdatedBy(username);
        userEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userDAO.save(userEntity);
        return true;
    }

    public void activateUserById(UserEntity userEntity){
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("1");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    public void deactivateUserById(UserEntity userEntity){
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("0");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    public void softDeleteUserById(UserEntity userEntity){
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsDeleted("1");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    public void restoreUserById(UserEntity userEntity){
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsDeleted("0");
        user.setIsActivated("1");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    public void hardDeleteUserById(UserEntity userEntity){
        userDAO.deleteById(userEntity.getId());
    }

    public void updateUserById(UserEntity userEntity){
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String username = userEntity.getUsername();
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        String phone = userEntity.getPhone();
        String avatar = userEntity.getAvatar();
        if (username != null){ user.setUsername(username); }
        if (email != null){ user.setEmail(email); }
        if (password != null){
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            user.setPassword(password);
        }
        if (phone != null){ user.setPhone(phone); }
        if (avatar != null){ user.setAvatar(avatar); }

        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    public UserEntity searchUserById(UserEntity userEntity){
        return userDAO.findById(userEntity.getId()).get();
    }

    public Page<UserEntity> searchAllUser(Integer pageIndex, Integer pageSize){
        return userDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}