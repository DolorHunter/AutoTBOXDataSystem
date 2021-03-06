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
        Integer userId = userRoleEntity.getUserId();
        Integer roleId = userRoleEntity.getRoleId();
        UserRoleEntity userRole = userRoleDAO.findByUserIdAndRoleId(userId, roleId);
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
    public boolean updateStatusById(UserRoleEntity userRoleEntity) {
        UserRoleEntity userRole = userRoleDAO.findById(userRoleEntity.getId()).get();
        String status = userRoleEntity.getStatus();
        if (status != null) {
            userRole.setStatus(status);
            userRole.setLastUpdatedBy(userRoleEntity.getLastUpdatedBy());
            userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
            userRoleDAO.save(userRole);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(UserRoleEntity userRoleEntity) {
        UserRoleEntity userRole = userRoleDAO.findById(userRoleEntity.getId()).get();
        String remark = userRoleEntity.getRemark();
        if (remark != null) {
            userRole.setRemark(remark);
            userRole.setLastUpdatedBy(userRoleEntity.getLastUpdatedBy());
            userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
            userRoleDAO.save(userRole);
            return true;
        }
        return false;
    }

    @Override
    public UserRoleEntity searchUserRoleById(UserRoleEntity userRoleEntity) {
        return userRoleDAO.findById(userRoleEntity.getId()).get();
    }

    @Override
    public Page<UserRoleEntity> searchUserRoleByUserId(UserRoleEntity userRoleEntity) {
        Integer pageIndex = userRoleEntity.getPageIndex();
        Integer pageSize = userRoleEntity.getPageSize();
        Integer userId = userRoleEntity.getUserId();
        return userRoleDAO.findByUserId(userId, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserRoleEntity> searchUserRoleByUsername(UserRoleEntity userRoleEntity) {
        Integer pageIndex = userRoleEntity.getPageIndex();
        Integer pageSize = userRoleEntity.getPageSize();
        String username = userRoleEntity.getUsername();
        return userRoleDAO.findByUsername(username, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserRoleEntity> searchUserRoleByRoleId(UserRoleEntity userRoleEntity) {
        Integer pageIndex = userRoleEntity.getPageIndex();
        Integer pageSize = userRoleEntity.getPageSize();
        Integer roleId = userRoleEntity.getRoleId();
        return userRoleDAO.findByRoleId(roleId, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserRoleEntity> searchUserRoleByRoleName(UserRoleEntity userRoleEntity) {
        Integer pageIndex = userRoleEntity.getPageIndex();
        Integer pageSize = userRoleEntity.getPageSize();
        String roleName = userRoleEntity.getRoleName();
        return userRoleDAO.findByRoleName(roleName, PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserRoleEntity> searchAllUserRole(UserRoleEntity userRoleEntity) {
        Integer pageIndex = userRoleEntity.getPageIndex();
        Integer pageSize = userRoleEntity.getPageSize();
        return userRoleDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
