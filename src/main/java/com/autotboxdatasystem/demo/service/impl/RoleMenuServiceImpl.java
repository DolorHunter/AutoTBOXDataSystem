package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.MenuDAO;
import com.autotboxdatasystem.demo.dao.RoleMenuDAO;
import com.autotboxdatasystem.demo.entity.MenuEntity;
import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import com.autotboxdatasystem.demo.service.RoleMenuService;
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
public class RoleMenuServiceImpl implements RoleMenuService {
    private final MenuDAO menuDAO;
    private final RoleMenuDAO roleMenuDAO;

    @Autowired
    public RoleMenuServiceImpl(MenuDAO menuDAO, RoleMenuDAO roleMenuDAO) {
        this.menuDAO = menuDAO;
        this.roleMenuDAO = roleMenuDAO;
    }

    @Override
    public boolean addMenu2Role(RoleMenuEntity roleMenuEntity) {
        Integer roleId = roleMenuEntity.getRoleId();
        Integer menuId = roleMenuEntity.getMenuId();
        RoleMenuEntity roleMenu = roleMenuDAO.findByRoleIdAndMenuId(roleId, menuId);
        if (roleMenu != null) {
            return false;
        }

        roleMenuEntity.setIsActivated("1");
        roleMenuEntity.setIsDeleted("0");

        roleMenuEntity.setCreatedDate(DateUtil.getCurDateTime());
        roleMenuEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        roleMenuDAO.save(roleMenuEntity);

        /* Add FatherMenu 2 RoleMenu */
        MenuEntity menu = menuDAO.findById(menuId).get();
        Integer fatherMenuId = menu.getFatherMenuId();
        if (!menuId.equals(fatherMenuId)) {
            MenuEntity fatherMenu = menuDAO.findById(fatherMenuId).get();
            String roleName = roleMenuEntity.getRoleName();
            Integer fatherId = fatherMenu.getId();
            String fatherName = fatherMenu.getMenuName();
            RoleMenuEntity roleMenuFather = new RoleMenuEntity();
            roleMenuFather.setRoleId(roleId);
            roleMenuFather.setRoleName(roleName);
            roleMenuFather.setMenuId(fatherId);
            roleMenuFather.setMenuName(fatherName);
            roleMenuFather.setCreatedBy(roleMenuEntity.getCreatedBy());
            roleMenuFather.setLastUpdatedBy(roleMenuEntity.getLastUpdatedBy());
            addMenu2Role(roleMenuFather);
        }
        return true;
    }

    @Override
    public void deleteRoleMenuByRoleId(RoleMenuEntity roleMenuEntity) {
        roleMenuDAO.deleteAllByRoleId(roleMenuEntity.getRoleId());
    }

    @Override
    public void deleteRoleMenuByRoleName(RoleMenuEntity roleMenuEntity) {
        roleMenuDAO.deleteAllByRoleName(roleMenuEntity.getRoleName());
    }

    @Override
    public void deleteRoleMenuByMenuId(RoleMenuEntity roleMenuEntity) {
        Integer menuId = roleMenuEntity.getMenuId();
        roleMenuDAO.deleteAllByMenuId(menuId);

        /* If all menu under fatherMenu is Deleted, delete fatherMenu */
        MenuEntity menu = menuDAO.findById(menuId).get();
        Integer fatherMenuId = menu.getFatherMenuId();
        if (!menuId.equals(fatherMenuId)) {
            List<MenuEntity> menuList = menuDAO.findByFatherMenuId(fatherMenuId);
            boolean isLastMenu = true;
            for (MenuEntity menu1 : menuList) {
                Integer menuId1 = menu1.getId();
                if (!menuId.equals(menuId1) && !menuId1.equals(fatherMenuId) &&
                        roleMenuDAO.findByMenuId(menuId1) != null) {
                    isLastMenu = false;
                    break;
                }
            }
            if (isLastMenu) {
                RoleMenuEntity roleMenuFather = new RoleMenuEntity();
                roleMenuFather.setMenuId(fatherMenuId);
                deleteRoleMenuByMenuId(roleMenuFather);
            }
        }
    }

    @Override
    public void deleteRoleMenuByMenuName(RoleMenuEntity roleMenuEntity) {
        String menuName = roleMenuEntity.getMenuName();
        roleMenuDAO.deleteAllByMenuName(menuName);

        /* If all menu under fatherMenu is Deleted, delete fatherMenu */
        MenuEntity menu = menuDAO.findByMenuName(menuName);
        Integer menuId = menu.getId();
        Integer fatherMenuId = menu.getFatherMenuId();
        if (!menuId.equals(fatherMenuId)) {
            List<MenuEntity> menuList = menuDAO.findByFatherMenuId(fatherMenuId);
            boolean isLastMenu = true;
            for (MenuEntity menu1 : menuList) {
                Integer menuId1 = menu1.getId();
                if (!menuId.equals(menuId1) && !menuId1.equals(fatherMenuId) &&
                        roleMenuDAO.findByMenuId(menuId1) != null) {
                    isLastMenu = false;
                    break;
                }
            }
            if (isLastMenu) {
                RoleMenuEntity roleMenuFather = new RoleMenuEntity();
                roleMenuFather.setMenuId(fatherMenuId);
                deleteRoleMenuByMenuId(roleMenuFather);
            }
        }
    }

    @Override
    public RoleMenuEntity searchRoleMenuById(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findById(roleMenuEntity.getId()).get();
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByRoleId(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByRoleId(roleMenuEntity.getRoleId());
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByRoleName(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByRoleName(roleMenuEntity.getRoleName());
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByMenuId(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByMenuId(roleMenuEntity.getMenuId());
    }

    @Override
    public List<RoleMenuEntity> searchRoleMenuByMenuName(RoleMenuEntity roleMenuEntity) {
        return roleMenuDAO.findByMenuName(roleMenuEntity.getMenuName());
    }

    @Override
    public Page<RoleMenuEntity> searchAllRoleMenu(Integer pageIndex, Integer pageSize) {
        return roleMenuDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
