package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/Menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 添加菜单
    @PostMapping(path = "/addMenu")
    public @ResponseBody
    ResponseEntity<String> addMenu(@RequestBody MenuEntity menuEntity) {
        if (!menuService.addMenu(menuEntity)) {
            return new ResponseEntity<>("Add Menu Failed. Menu name existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 硬删除菜单
    @PostMapping(path = "/hardDeleteMenuById")
    public @ResponseBody
    ResponseEntity<String> hardDeleteMenuById(@RequestBody MenuEntity menuEntity) {
        menuService.hardDeleteMenuById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 软删除菜单
    @PostMapping(path = "/softDeleteMenuById")
    public @ResponseBody
    ResponseEntity<String> softDeleteMenuById(@RequestBody MenuEntity menuEntity) {
        menuService.softDeleteMenuById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 恢复软删除菜单
    @PostMapping(path = "/restoreMenuById")
    public @ResponseBody
    ResponseEntity<String> restoreMenuById(@RequestBody MenuEntity menuEntity) {
        menuService.restoreMenuById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 激活菜单
    @PostMapping(path = "/activateMenuById")
    public @ResponseBody
    ResponseEntity<String> activateMenuById(@RequestBody MenuEntity menuEntity) {
        menuService.activateMenuById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 禁用菜单
    @PostMapping(path = "/deactivateMenuById")
    public @ResponseBody
    ResponseEntity<String> deactivateMenuById(@RequestBody MenuEntity menuEntity) {
        menuService.deactivateMenuById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }


    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody MenuEntity menuEntity) {
        menuService.updateStatusById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody MenuEntity menuEntity) {
        menuService.updateRemarkById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新菜单信息
    @PostMapping(path = "/updateMenuById")
    public @ResponseBody
    ResponseEntity<String> updateMenuById(@RequestBody MenuEntity menuEntity) {
        menuService.updateMenuById(menuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找菜单
    @PostMapping(path = "/searchMenuById")
    public @ResponseBody
    MenuEntity searchMenuById(@RequestBody MenuEntity menuEntity) {
        return menuService.searchMenuById(menuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 菜单名查找菜单
    @PostMapping(path = "/searchMenuByMenuName")
    public @ResponseBody
    MenuEntity searchMenuByMenuName(@RequestBody MenuEntity menuEntity) {
        return menuService.searchMenuByMenuName(menuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找激活菜单
    @PostMapping(path = "/searchActivedMenu")
    public @ResponseBody
    Page<MenuEntity> searchActivedMenu(@RequestBody MenuEntity menuEntity) {
        return menuService.searchActivedMenu(menuEntity);
    }

    // 查找全部菜单
    @PostMapping(path = "/searchAllMenu")
    public @ResponseBody
    Page<MenuEntity> searchAllMenu(@RequestBody MenuEntity menuEntity) {
        return menuService.searchAllMenu(menuEntity);
    }
}
