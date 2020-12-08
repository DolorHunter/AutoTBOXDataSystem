package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/UserRole")
public class UserRoleController {
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // 为用户添加角色
    @PostMapping(path = "/addRole2User")
    public @ResponseBody
    ResponseEntity<String> addRole2User(@RequestBody UserRoleEntity userRoleEntity) {
        if (!userRoleService.addRole2User(userRoleEntity)) {
            return new ResponseEntity<>("Add UserRole Failed. User-Role existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户ID硬删除用户角色
    @PostMapping(path = "/deleteUserRoleByUserId")
    public @ResponseBody
    ResponseEntity<String> deleteUserRoleByUserId(@RequestBody UserRoleEntity userRoleEntity) {
        userRoleService.deleteUserRoleByUserId(userRoleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名硬删除用户角色
    @PostMapping(path = "/deleteUserRoleByUsername")
    public @ResponseBody
    ResponseEntity<String> deleteUserRoleByUsername(@RequestBody UserRoleEntity userRoleEntity) {
        userRoleService.deleteUserRoleByUsername(userRoleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色ID硬删除用户角色
    @PostMapping(path = "/deleteUserRoleByRoleId")
    public @ResponseBody
    ResponseEntity<String> deleteUserRoleByRoleId(@RequestBody UserRoleEntity userRoleEntity) {
        userRoleService.deleteUserRoleByRoleId(userRoleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名硬删除用户角色
    @PostMapping(path = "/deleteUserRoleByRoleName")
    public @ResponseBody
    ResponseEntity<String> deleteUserRoleByRoleName(@RequestBody UserRoleEntity userRoleEntity) {
        userRoleService.deleteUserRoleByRoleName(userRoleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找角用户角色
    @PostMapping(path = "/searchUserRoleById")
    public @ResponseBody
    UserRoleEntity searchUserRoleById(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleById(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户ID查找用户角色
    @PostMapping(path = "/searchUserRoleByUserId")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByUserId(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByUserId(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名查找用户角色
    @PostMapping(path = "/searchUserRoleByUsername")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByUsername(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByUsername(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色ID查找用户角色
    @PostMapping(path = "/searchUserRoleByRoleId")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByRoleId(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByRoleId(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名查找用户角色
    @PostMapping(path = "/searchUserRoleByRoleName")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByRoleName(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByRoleName(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部用户角色
    @PostMapping(path = "/searchAllUserRole")
    public @ResponseBody
    Page<UserRoleEntity> searchAllUserRole(@RequestBody PageEntity pageEntity) {
        Integer pageIndex = pageEntity.getPageIndex();
        Integer pageSize = pageEntity.getPageSize();
        return userRoleService.searchAllUserRole(pageIndex, pageSize);
    }
}
