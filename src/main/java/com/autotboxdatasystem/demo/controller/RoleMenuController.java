package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/RoleMenu")
public class RoleMenuController {
    private final RoleMenuService roleMenuService;

    @Autowired
    public RoleMenuController(RoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }

    // 为角色添加菜单
    @PostMapping(path = "/addMenu2Role")
    public @ResponseBody
    ResponseEntity<String> addMenu2Role(@RequestBody RoleMenuEntity roleMenuEntity) {
        if (!roleMenuService.addMenu2Role(roleMenuEntity)) {
            return new ResponseEntity<>("Add RoleMenu Failed. Role-Menu existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色ID硬删除角色菜单
    @PostMapping(path = "/deleteRoleMenuByRoleId")
    public @ResponseBody
    ResponseEntity<String> deleteRoleMenuByRoleId(@RequestBody RoleMenuEntity roleMenuEntity) {
        roleMenuService.deleteRoleMenuByRoleId(roleMenuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名硬删除角色菜单
    @PostMapping(path = "/deleteRoleMenuByRoleName")
    public @ResponseBody
    ResponseEntity<String> deleteRoleMenuByRoleName(@RequestBody RoleMenuEntity roleMenuEntity) {
        roleMenuService.deleteRoleMenuByRoleName(roleMenuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 菜单ID硬删除角色菜单
    @PostMapping(path = "/deleteRoleMenuByMenuId")
    public @ResponseBody
    ResponseEntity<String> deleteRoleMenuByMenuId(@RequestBody RoleMenuEntity roleMenuEntity) {
        roleMenuService.deleteRoleMenuByMenuId(roleMenuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 菜单名硬删除角色菜单
    @PostMapping(path = "/deleteRoleMenuByMenuName")
    public @ResponseBody
    ResponseEntity<String> deleteRoleMenuByMenuName(@RequestBody RoleMenuEntity roleMenuEntity) {
        roleMenuService.deleteRoleMenuByMenuName(roleMenuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody RoleMenuEntity roleMenuEntity) {
        roleMenuService.updateStatusById(roleMenuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody RoleMenuEntity roleMenuEntity) {
        roleMenuService.updateRemarkById(roleMenuEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找角色菜单
    @PostMapping(path = "/searchRoleMenuById")
    public @ResponseBody
    RoleMenuEntity searchRoleMenuById(@RequestBody RoleMenuEntity roleMenuEntity) {
        return roleMenuService.searchRoleMenuById(roleMenuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色ID查找角色菜单
    @PostMapping(path = "/searchRoleMenuByRoleId")
    public @ResponseBody
    List<RoleMenuEntity> searchRoleMenuByRoleId(@RequestBody RoleMenuEntity roleMenuEntity) {
        return roleMenuService.searchRoleMenuByRoleId(roleMenuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名查找角色菜单
    @PostMapping(path = "/searchRoleMenuByRoleName")
    public @ResponseBody
    List<RoleMenuEntity> searchRoleMenuByRoleName(@RequestBody RoleMenuEntity roleMenuEntity) {
        return roleMenuService.searchRoleMenuByRoleName(roleMenuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 菜单ID查找角色菜单
    @PostMapping(path = "/searchRoleMenuByMenuId")
    public @ResponseBody
    List<RoleMenuEntity> searchRoleMenuByMenuId(@RequestBody RoleMenuEntity roleMenuEntity) {
        return roleMenuService.searchRoleMenuByMenuId(roleMenuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 菜单名查找角色菜单
    @PostMapping(path = "/searchRoleMenuByMenuName")
    public @ResponseBody
    List<RoleMenuEntity> searchRoleMenuByMenuName(@RequestBody RoleMenuEntity roleMenuEntity) {
        return roleMenuService.searchRoleMenuByMenuName(roleMenuEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部角色菜单
    @PostMapping(path = "/searchAllRoleMenu")
    public @ResponseBody
    Page<RoleMenuEntity> searchAllRoleMenu(@RequestBody PageEntity pageEntity) {
        Integer pageIndex = pageEntity.getPageIndex();
        Integer pageSize = pageEntity.getPageSize();
        return roleMenuService.searchAllRoleMenu(pageIndex, pageSize);
    }
}
