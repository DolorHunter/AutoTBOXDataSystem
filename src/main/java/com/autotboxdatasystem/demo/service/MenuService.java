package com.autotboxdatasystem.demo.service;

import com.autotboxdatasystem.demo.entity.MenuEntity;
import org.springframework.data.domain.Page;

public interface MenuService {
    boolean addMenu(MenuEntity menuEntity);

    void hardDeleteMenuById(MenuEntity menuEntity);

    void softDeleteMenuById(MenuEntity menuEntity);

    void restoreMenuById(MenuEntity menuEntity);

    void activateMenuById(MenuEntity menuEntity);

    void deactivateMenuById(MenuEntity menuEntity);

    void updateMenuById(MenuEntity menuEntity);

    boolean updateStatusById(MenuEntity menuEntity);

    boolean updateRemarkById(MenuEntity menuEntity);

    MenuEntity searchMenuById(MenuEntity menuEntity);

    MenuEntity searchMenuByMenuName(MenuEntity menuEntity);

    Page<MenuEntity> searchActivedMenu(MenuEntity menuEntity);

    Page<MenuEntity> searchAllMenu(MenuEntity menuEntity);
}
