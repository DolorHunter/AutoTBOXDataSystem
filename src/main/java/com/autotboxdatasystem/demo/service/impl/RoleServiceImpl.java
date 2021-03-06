package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.RoleDAO;
import com.autotboxdatasystem.demo.dao.RoleMenuDAO;
import com.autotboxdatasystem.demo.dao.UserRoleDAO;
import com.autotboxdatasystem.demo.entity.RoleEntity;
import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import com.autotboxdatasystem.demo.entity.UserRoleEntity;
import com.autotboxdatasystem.demo.service.RoleService;
import com.autotboxdatasystem.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;
    private final UserRoleDAO userRoleDAO;
    private final RoleMenuDAO roleMenuDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO, UserRoleDAO userRoleDAO, RoleMenuDAO roleMenuDAO) {
        this.roleDAO = roleDAO;
        this.userRoleDAO = userRoleDAO;
        this.roleMenuDAO = roleMenuDAO;
    }

    @Override
    public boolean addRole(RoleEntity roleEntity) {
        RoleEntity role = roleDAO.findByRoleName(roleEntity.getRoleName());
        if (role != null) {
            return false;
        }

        roleEntity.setIsActivated("1");
        roleEntity.setIsDeleted("0");

        roleEntity.setCreatedDate(DateUtil.getCurDateTime());
        roleEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        roleDAO.save(roleEntity);
        return true;
    }

    @Override
    public void activateRoleById(RoleEntity roleEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByRoleId(roleEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("1");
                userRole.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByRoleId(roleEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("1");
                roleMenu.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                roleMenuDAO.save(roleMenu);
            }
        }

        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        role.setIsActivated("1");
        role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
        role.setLastUpdatedDate(DateUtil.getCurDateTime());
        roleDAO.save(role);
    }

    @Override
    public void deactivateRoleById(RoleEntity roleEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByRoleId(roleEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("0");
                userRole.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByRoleId(roleEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("0");
                roleMenu.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                roleMenuDAO.save(roleMenu);
            }
        }

        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        role.setIsActivated("0");
        role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
        role.setLastUpdatedDate(DateUtil.getCurDateTime());
        roleDAO.save(role);
    }

    @Override
    public void softDeleteRoleById(RoleEntity roleEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByRoleId(roleEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("0");
                userRole.setIsDeleted("1");
                userRole.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByRoleId(roleEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("0");
                roleMenu.setIsDeleted("1");
                roleMenu.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                roleMenuDAO.save(roleMenu);
            }
        }

        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        role.setIsActivated("0");
        role.setIsDeleted("1");
        role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
        role.setLastUpdatedDate(DateUtil.getCurDateTime());
        roleDAO.save(role);
    }

    @Override
    public void restoreRoleById(RoleEntity roleEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByRoleId(roleEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("1");
                userRole.setIsDeleted("0");
                userRole.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByRoleId(roleEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("1");
                roleMenu.setIsDeleted("0");
                roleMenu.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                roleMenuDAO.save(roleMenu);
            }
        }

        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        role.setIsActivated("1");
        role.setIsDeleted("0");
        role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
        role.setLastUpdatedDate(DateUtil.getCurDateTime());
        roleDAO.save(role);
    }

    @Override
    public void hardDeleteRoleById(RoleEntity roleEntity) {
        userRoleDAO.deleteAllByRoleId(roleEntity.getId());
        roleMenuDAO.deleteAllByRoleId(roleEntity.getId());
        roleDAO.deleteById(roleEntity.getId());
    }

    @Override
    public boolean updateStatusById(RoleEntity roleEntity) {
        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        String status = roleEntity.getStatus();
        if (status != null) {
            role.setStatus(status);
            role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
            role.setLastUpdatedDate(DateUtil.getCurDateTime());
            roleDAO.save(role);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(RoleEntity roleEntity) {
        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        String remark = roleEntity.getRemark();
        if (remark != null) {
            role.setRemark(remark);
            role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
            role.setLastUpdatedDate(DateUtil.getCurDateTime());
            roleDAO.save(role);
            return true;
        }
        return false;
    }

    @Override
    public void updateRoleById(RoleEntity roleEntity) {
        RoleEntity role = roleDAO.findById(roleEntity.getId()).get();
        String roleName = roleEntity.getRoleName();
        String roleType = roleEntity.getRoleType();
        Integer fatherRoleId = roleEntity.getFatherRoleId();
        if (roleName != null) {
            List<UserRoleEntity> userRoleList = userRoleDAO.findByRoleId(role.getId());
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setRoleName(roleName);
                    userRole.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                    userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                    userRoleDAO.save(userRole);
                }
            }
            List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByRoleId(role.getId());
            if (roleMenuList != null) {
                for (RoleMenuEntity roleMenu : roleMenuList) {
                    roleMenu.setRoleName(roleName);
                    roleMenu.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
                    roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                    roleMenuDAO.save(roleMenu);
                }
            }
            role.setRoleName(roleName);
        }
        if (roleType != null) {
            role.setRoleType(roleType);
        }
        if (fatherRoleId != null) {
            role.setFatherRoleId(fatherRoleId);
        }

        role.setLastUpdatedBy(roleEntity.getLastUpdatedBy());
        role.setLastUpdatedDate(DateUtil.getCurDateTime());
        roleDAO.save(role);
    }

    @Override
    public RoleEntity searchRoleById(RoleEntity roleEntity) {
        return roleDAO.findById(roleEntity.getId()).get();
    }

    @Override
    public RoleEntity searchRoleByRoleName(RoleEntity roleEntity) {
        return roleDAO.findByRoleName(roleEntity.getRoleName());
    }

    @Override
    public Page<RoleEntity> searchActivedRole(RoleEntity roleEntity) {
        Integer pageIndex = roleEntity.getPageIndex();
        Integer pageSize = roleEntity.getPageSize();
        return roleDAO.findByIsActivated("1", PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<RoleEntity> searchAllRole(RoleEntity roleEntity) {
        Integer pageIndex = roleEntity.getPageIndex();
        Integer pageSize = roleEntity.getPageSize();
        return roleDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
