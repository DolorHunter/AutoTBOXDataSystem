package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/Role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // 添加角色
    @PostMapping(path = "/addRole")
    public @ResponseBody
    ResponseEntity<String> addRole(@RequestBody RoleEntity roleEntity) {
        if (!roleService.addRole(roleEntity)) {
            return new ResponseEntity<>("Add Role Failed. Role name existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 硬删除角色
    @PostMapping(path = "/hardDeleteRoleById")
    public @ResponseBody
    ResponseEntity<String> hardDeleteRoleById(@RequestBody RoleEntity roleEntity) {
        roleService.hardDeleteRoleById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 软删除角色
    @PostMapping(path = "/softDeleteRoleById")
    public @ResponseBody
    ResponseEntity<String> softDeleteRoleById(@RequestBody RoleEntity roleEntity) {
        roleService.softDeleteRoleById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 恢复软删除角色
    @PostMapping(path = "/restoreRoleById")
    public @ResponseBody
    ResponseEntity<String> restoreRoleById(@RequestBody RoleEntity roleEntity) {
        roleService.restoreRoleById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 激活角色
    @PostMapping(path = "/activateRoleById")
    public @ResponseBody
    ResponseEntity<String> activateRoleById(@RequestBody RoleEntity roleEntity) {
        roleService.activateRoleById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 禁用角色
    @PostMapping(path = "/deactivateRoleById")
    public @ResponseBody
    ResponseEntity<String> deactivateRoleById(@RequestBody RoleEntity roleEntity) {
        roleService.deactivateRoleById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody RoleEntity roleEntity) {
        roleService.updateStatusById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody RoleEntity roleEntity) {
        roleService.updateRemarkById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新角色信息
    @PostMapping(path = "/updateRoleById")
    public @ResponseBody
    ResponseEntity<String> updateRoleById(@RequestBody RoleEntity roleEntity) {
        roleService.updateRoleById(roleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找角色
    @PostMapping(path = "/searchRoleById")
    public @ResponseBody
    RoleEntity searchRoleById(@RequestBody RoleEntity roleEntity) {
        return roleService.searchRoleById(roleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名查找角色
    @PostMapping(path = "/searchRoleByRoleName")
    public @ResponseBody
    RoleEntity searchRoleByRoleName(@RequestBody RoleEntity roleEntity) {
        return roleService.searchRoleByRoleName(roleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找激活角色
    @PostMapping(path = "/searchActivedRoleList")
    public @ResponseBody
    List<RoleEntity> searchActivedRoleList(@RequestBody RoleEntity roleEntity) {
        return roleService.searchActivedRoleList(roleEntity);
    }

    // 查找激活角色
    @PostMapping(path = "/searchActivedRolePager")
    public @ResponseBody
    Page<RoleEntity> searchActivedRolePager(@RequestBody RoleEntity roleEntity) {
        return roleService.searchActivedRolePager(roleEntity);
    }

    // 查找全部角色
    @PostMapping(path = "/searchAllRoleList")
    public @ResponseBody
    List<RoleEntity> searchAllRoleList(@RequestBody RoleEntity roleEntity) {
        return roleService.searchAllRoleList(roleEntity);
    }

    // 查找全部角色
    @PostMapping(path = "/searchAllRolePager")
    public @ResponseBody
    Page<RoleEntity> searchAllRolePager(@RequestBody RoleEntity roleEntity) {
        return roleService.searchAllRolePager(roleEntity);
    }
}
