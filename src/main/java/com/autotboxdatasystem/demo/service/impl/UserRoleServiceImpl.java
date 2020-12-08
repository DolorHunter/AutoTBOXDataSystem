package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.UserRoleDAO;
import com.autotboxdatasystem.demo.entity.UserRoleEntity;
import com.autotboxdatasystem.demo.service.UserRoleService;
import com.autotboxdatasystem.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleDAO userRoleDAO;

    @Autowired
    public UserRoleServiceImpl(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public boolean addRole2User(UserRoleEntity userRoleEntity) {
        UserRoleEntity userRole = userRoleDAO.findByUserIdAndRoleId(userRoleEntity.getUserId(), userRoleEntity.getRoleId());
        if (userRole != null) {
            return false;
        }

        userRoleEntity.setIsActivated("1");
        userRoleEntity.setIsDeleted("0");

        userRoleEntity.setCreatedDate(DateUtil.getCurDateTime());
        userRoleEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userRoleDAO.save(userRoleEntity);
        return true;
    }

    @Override
    public void deleteUserRoleByUserId(UserRoleEntity userRoleEntity) {
        userRoleDAO.deleteAllByUserId(userRoleEntity.getUserId());
    }

    @Override
    public void deleteUserRoleByUsername(UserRoleEntity userRoleEntity) {
        userRoleDAO.deleteAllByUsername(userRoleEntity.getUsername());
    }

    @Override
    public void deleteUserRoleByRoleId(UserRoleEntity userRoleEntity) {
        userRoleDAO.deleteAllByRoleId(userRoleEntity.getRoleId());
    }

    @Override
    public void deleteUserRoleByRoleName(UserRoleEntity userRoleEntity) {
        userRoleDAO.deleteAllByRoleName(userRoleEntity.getRoleName());
    }

    @Override
    public UserRoleEntity searchUserRoleById(UserRoleEntity userRoleEntity) {
        return userRoleDAO.findById(userRoleEntity.getId()).get();
    }

    @Override
    public List<UserRoleEntity> searchUserRoleByUserId(UserRoleEntity userRoleEntity) {
        return userRoleDAO.findByUserId(userRoleEntity.getUserId());
    }

    @Override
    public List<UserRoleEntity> searchUserRoleByUsername(UserRoleEntity userRoleEntity) {
        return userRoleDAO.findByUsername(userRoleEntity.getUsername());
    }

    @Override
    public List<UserRoleEntity> searchUserRoleByRoleId(UserRoleEntity userRoleEntity) {
        return userRoleDAO.findByRoleId(userRoleEntity.getRoleId());
    }

    @Override
    public List<UserRoleEntity> searchUserRoleByRoleName(UserRoleEntity userRoleEntity) {
        return userRoleDAO.findByRoleName(userRoleEntity.getRoleName());
    }

    @Override
    public Page<UserRoleEntity> searchAllUserRole(Integer pageIndex, Integer pageSize) {
        return userRoleDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
