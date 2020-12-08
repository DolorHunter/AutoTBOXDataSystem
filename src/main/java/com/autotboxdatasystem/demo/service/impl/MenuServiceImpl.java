package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.MenuDAO;
import com.autotboxdatasystem.demo.dao.RoleMenuDAO;
import com.autotboxdatasystem.demo.entity.MenuEntity;
import com.autotboxdatasystem.demo.entity.RoleMenuEntity;
import com.autotboxdatasystem.demo.service.MenuService;
import com.autotboxdatasystem.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuDAO menuDAO;
    private final RoleMenuDAO roleMenuDAO;

    @Autowired
    public MenuServiceImpl(MenuDAO menuDAO, RoleMenuDAO roleMenuDAO) {
        this.menuDAO = menuDAO;
        this.roleMenuDAO = roleMenuDAO;
    }

    public boolean addMenu(MenuEntity menuEntity) {
        MenuEntity menu = menuDAO.findByMenuName(menuEntity.getMenuName());
        if (menu != null) {
            return false;
        }

        menuEntity.setIsActivated("1");
        menuEntity.setIsDeleted("0");

        menuEntity.setCreatedDate(DateUtil.getCurDateTime());
        menuEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        menuDAO.save(menuEntity);
        return true;
    }

    @Override
    public void hardDeleteMenuById(MenuEntity menuEntity) {
        roleMenuDAO.deleteAllByMenuId(menuEntity.getId());
        menuDAO.deleteById(menuEntity.getId());
    }

    @Override
    public void softDeleteMenuById(MenuEntity menuEntity) {
        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByMenuId(menuEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("0");
                roleMenu.setIsDeleted("1");
                roleMenuDAO.save(roleMenu);
            }
        }

        MenuEntity menu = menuDAO.findById(menuEntity.getId()).get();
        menu.setIsActivated("0");
        menu.setIsDeleted("1");
        menu.setLastUpdatedDate(DateUtil.getCurDateTime());
        menuDAO.save(menu);
    }

    @Override
    public void restoreMenuById(MenuEntity menuEntity) {
        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByMenuId(menuEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("1");
                roleMenu.setIsDeleted("0");
                roleMenuDAO.save(roleMenu);
            }
        }

        MenuEntity menu = menuDAO.findById(menuEntity.getId()).get();
        menu.setIsActivated("1");
        menu.setIsDeleted("0");
        menu.setLastUpdatedDate(DateUtil.getCurDateTime());
        menuDAO.save(menu);
    }

    @Override
    public void activateMenuById(MenuEntity menuEntity) {
        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByMenuId(menuEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("1");
                roleMenuDAO.save(roleMenu);
            }
        }

        MenuEntity menu = menuDAO.findById(menuEntity.getId()).get();
        menu.setIsActivated("1");
        menu.setLastUpdatedDate(DateUtil.getCurDateTime());
        menuDAO.save(menu);
    }

    @Override
    public void deactivateMenuById(MenuEntity menuEntity) {
        List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByMenuId(menuEntity.getId());
        if (roleMenuList != null) {
            for (RoleMenuEntity roleMenu : roleMenuList) {
                roleMenu.setIsActivated("0");
                roleMenuDAO.save(roleMenu);
            }
        }

        MenuEntity menu = menuDAO.findById(menuEntity.getId()).get();
        menu.setIsActivated("0");
        menu.setLastUpdatedDate(DateUtil.getCurDateTime());
        menuDAO.save(menu);
    }

    @Override
    public void updateMenuById(MenuEntity menuEntity) {
        MenuEntity menu = menuDAO.findById(menuEntity.getId()).get();
        String menuName = menuEntity.getMenuName();
        String menuType = menuEntity.getMenuType();
        Integer fatherMenuId = menuEntity.getFatherMenuId();
        if (menuName != null) {
            List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByMenuName(menuName);
            if (roleMenuList != null) {
                for (RoleMenuEntity roleMenu : roleMenuList) {
                    roleMenu.setMenuName(menuName);
                    roleMenuDAO.save(roleMenu);
                }
            }
            menu.setMenuName(menuName);
        }
        if (menuType != null) {
            menu.setMenuType(menuType);
        }
        if (fatherMenuId != null) {
            menu.setFatherMenuId(fatherMenuId);
        }

        menu.setLastUpdatedDate(DateUtil.getCurDateTime());
        menuDAO.save(menu);
    }

    @Override
    public MenuEntity searchMenuById(MenuEntity menuEntity) {
        return menuDAO.findById(menuEntity.getId()).get();
    }

    @Override
    public MenuEntity searchMenuByMenuName(MenuEntity menuEntity) {
        return menuDAO.findByMenuName(menuEntity.getMenuName());
    }

    @Override
    public Page<MenuEntity> searchActivedMenu(Integer pageIndex, Integer pageSize) {
        return menuDAO.findByIsActivated("1", PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<MenuEntity> searchAllMenu(Integer pageIndex, Integer pageSize) {
        return menuDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}
