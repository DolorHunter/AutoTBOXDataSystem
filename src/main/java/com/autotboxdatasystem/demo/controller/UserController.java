package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.UserEntity;
import com.autotboxdatasystem.demo.entity.PageEntity;
import com.autotboxdatasystem.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 注册
    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<String> register(@RequestBody UserEntity userEntity) {
        String ans = userService.addUser(userEntity);
        if (!ans.equals("")) {
            return new ResponseEntity<>("Register Failed. " + ans, HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 登入
    @PostMapping(path = "/login")
    public @ResponseBody
    ResponseEntity<String> login(@RequestBody UserEntity userEntity) {
        if (!userService.login(userEntity)) {
            return new ResponseEntity<>("Incorrect Username or Password.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 添加用户
    @PostMapping(path = "/addUser")
    public @ResponseBody
    ResponseEntity<String> addUser(@RequestBody UserEntity userEntity) {
        String ans = userService.addUser(userEntity);
        if (!ans.equals("")) {
            return new ResponseEntity<>("Add User Failed. " + ans, HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 硬删除用户
    @PostMapping(path = "/hardDeleteUserById")
    public @ResponseBody
    ResponseEntity<String> hardDeleteUserById(@RequestBody UserEntity userEntity) {
        userService.hardDeleteUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 软删除用户
    @PostMapping(path = "/softDeleteUserById")
    public @ResponseBody
    ResponseEntity<String> softDeleteUserById(@RequestBody UserEntity userEntity) {
        userService.softDeleteUserById(userEntity);
        userService.deactivateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 恢复软删除用户
    @PostMapping(path = "/restoreUserById")
    public @ResponseBody
    ResponseEntity<String> restoreUserById(@RequestBody UserEntity userEntity) {
        userService.restoreUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 激活用户
    @PostMapping(path = "/activateUserById")
    public @ResponseBody
    ResponseEntity<String> activateUserById(@RequestBody UserEntity userEntity) {
        userService.activateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 禁用用户
    @PostMapping(path = "/deactivateUserById")
    public @ResponseBody
    ResponseEntity<String> deactivateUserById(@RequestBody UserEntity userEntity) {
        userService.deactivateUserById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody UserEntity userEntity) {
        userService.updateStatusById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody UserEntity userEntity) {
        userService.updateRemarkById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新用户名
    @PostMapping(path = "/updateUsernameById")
    public @ResponseBody
    ResponseEntity<String> updateUsernameById(@RequestBody UserEntity userEntity) {
        if (!userService.updateUsernameById(userEntity)) {
            return new ResponseEntity<>("Update Username Failed. Username was token, illegal or none.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新邮箱
    @PostMapping(path = "/updateEmailById")
    public @ResponseBody
    ResponseEntity<String> updateEmailById(@RequestBody UserEntity userEntity) {
        if (!userService.updateEmailById(userEntity)) {
            return new ResponseEntity<>("Update Email Failed. Email was not email or token, illegal or none.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新电话
    @PostMapping(path = "/updatePhoneById")
    public @ResponseBody
    ResponseEntity<String> updatePhoneById(@RequestBody UserEntity userEntity) {
        if (!userService.updatePhoneById(userEntity)) {
            return new ResponseEntity<>("Update Phone Failed. Phone was token, illegal or none.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新密码
    @PostMapping(path = "/updatePasswordById")
    public @ResponseBody
    ResponseEntity<String> updatePasswordById(@RequestBody UserEntity userEntity) {
        if (!userService.updatePasswordById(userEntity)) {
            return new ResponseEntity<>("Update Password Failed. Password was illegal or none.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新头像
    @PostMapping(path = "/updateAvatarById")
    public @ResponseBody
    ResponseEntity<String> updateAvatarById(@RequestBody UserEntity userEntity) {
        if (!userService.updateAvatarById(userEntity)) {
            return new ResponseEntity<>("Update Avatar Failed. Avatar was none.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 重置用户密码
    @PostMapping(path = "/resetPasswordById")
    public @ResponseBody
    ResponseEntity<String> resetPasswordById(@RequestBody UserEntity userEntity) {
        userService.resetPasswordById(userEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找用户
    @PostMapping(path = "/searchUserById")
    public @ResponseBody
    UserEntity searchUserById(@RequestBody UserEntity userEntity) {
        return userService.searchUserById(userEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名查找用户
    @PostMapping(path = "/searchUserByUsername")
    public @ResponseBody
    UserEntity searchUserByUsername(@RequestBody UserEntity userEntity) {
        return userService.searchUserByUsername(userEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找激活用户
    @PostMapping(path = "/searchActivedUser")
    public @ResponseBody
    Page<UserEntity> searchActivedUser(@RequestBody PageEntity pageEntity) {
        Integer pageIndex = pageEntity.getPageIndex();
        Integer pageSize = pageEntity.getPageSize();
        return userService.searchActivedUser(pageIndex, pageSize);
    }

    // 查找全部用户
    @PostMapping(path = "/searchAllUser")
    public @ResponseBody
    Page<UserEntity> searchAllUser(@RequestBody PageEntity pageEntity) {
        Integer pageIndex = pageEntity.getPageIndex();
        Integer pageSize = pageEntity.getPageSize();
        return userService.searchAllUser(pageIndex, pageSize);
    }
}
