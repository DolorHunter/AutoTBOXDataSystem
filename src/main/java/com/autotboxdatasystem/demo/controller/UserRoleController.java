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

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody UserRoleEntity userRoleEntity) {
        userRoleService.updateStatusById(userRoleEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody UserRoleEntity userRoleEntity) {
        userRoleService.updateRemarkById(userRoleEntity);
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
    @PostMapping(path = "/searchUserRoleByUserIdList")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByUserIdList(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByUserIdList(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户ID查找用户角色
    @PostMapping(path = "/searchUserRoleByUserIdPager")
    public @ResponseBody
    Page<UserRoleEntity> searchUserRoleByUserIdPager(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByUserIdPager(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名查找用户角色
    @PostMapping(path = "/searchUserRoleByUsernameList")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByUsernameList(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByUsernameList(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名查找用户角色
    @PostMapping(path = "/searchUserRoleByUsernamePager")
    public @ResponseBody
    Page<UserRoleEntity> searchUserRoleByUsernamePager(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByUsernamePager(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色ID查找用户角色
    @PostMapping(path = "/searchUserRoleByRoleIdList")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByRoleIdList(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByRoleIdList(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色ID查找用户角色
    @PostMapping(path = "/searchUserRoleByRoleIdPager")
    public @ResponseBody
    Page<UserRoleEntity> searchUserRoleByRoleIdPager(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByRoleIdPager(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名查找用户角色
    @PostMapping(path = "/searchUserRoleByRoleNameList")
    public @ResponseBody
    List<UserRoleEntity> searchUserRoleByRoleNameList(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByRoleNameList(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 角色名查找用户角色
    @PostMapping(path = "/searchUserRoleByRoleNamePager")
    public @ResponseBody
    Page<UserRoleEntity> searchUserRoleByRoleNamePager(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchUserRoleByRoleNamePager(userRoleEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部用户角色
    @PostMapping(path = "/searchAllUserRoleList")
    public @ResponseBody
    List<UserRoleEntity> searchAllUserRoleList(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchAllUserRoleList(userRoleEntity);
    }

    // 查找全部用户角色
    @PostMapping(path = "/searchAllUserRolePager")
    public @ResponseBody
    Page<UserRoleEntity> searchAllUserRolePager(@RequestBody UserRoleEntity userRoleEntity) {
        return userRoleService.searchAllUserRolePager(userRoleEntity);
    }
}
