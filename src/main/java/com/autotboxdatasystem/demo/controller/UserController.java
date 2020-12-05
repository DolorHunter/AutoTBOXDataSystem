package com.autotboxdatasystem.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.autotboxdatasystem.demo.entity.UserEntity;
import com.autotboxdatasystem.demo.entity.PageEntity;
import com.autotboxdatasystem.demo.service.UserService;

@Controller
@RequestMapping(path="/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 添加用户
    @PostMapping(path="/addUser")
    public @ResponseBody ResponseEntity<String> addUser (@RequestBody UserEntity userEntity){
        if (!userService.addUser(userEntity)){
            return new ResponseEntity<>("Add User Failed. Email & Phone was taken.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Succeed.", HttpStatus.OK);
        }
    }

    // 硬删除用户
    @PostMapping(path="/hardDeleteUserById")
    public @ResponseBody ResponseEntity<String> hardDeleteUserById (@RequestBody UserEntity userEntity){
        userService.hardDeleteUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 软删除用户
    @PostMapping(path="/softDeleteUserById")
    public @ResponseBody ResponseEntity<String> softDeleteUserById (@RequestBody UserEntity userEntity){
        userService.softDeleteUserById(userEntity);
        userService.deactivateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 恢复软删除用户
    @PostMapping(path="/restoreUserById")
    public @ResponseBody ResponseEntity<String> restoreUserById (@RequestBody UserEntity userEntity){
        userService.restoreUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 激活用户
    @PostMapping(path="/activateUserById")
    public @ResponseBody ResponseEntity<String> activateUserById (@RequestBody UserEntity userEntity){
        userService.activateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 禁用用户
    @PostMapping(path="/deactivateUserById")
    public @ResponseBody ResponseEntity<String> deactivateUserById (@RequestBody UserEntity userEntity){
        userService.deactivateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新用户信息
    @PostMapping(path="/updateUserById")
    public @ResponseBody ResponseEntity<String> updateUserById (@RequestBody UserEntity userEntity){
        userService.updateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找用户
    @PostMapping(path="/searchUserById")
    public @ResponseBody UserEntity searchUserById (@RequestBody UserEntity userEntity){
        return userService.searchUserById(userEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部用户
    @PostMapping(path="/searchAllUser")
    public @ResponseBody Page<UserEntity> searchAllUser (@RequestBody PageEntity pageEntity){
        Integer pageIndex = pageEntity.getPageIndex();
        Integer pageSize = pageEntity.getPageSize();
        return userService.searchAllUser(pageIndex, pageSize);
    }

}
