package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/UserCar")
public class UserCarController {
    private final UserCarService userCarService;

    @Autowired
    public UserCarController(UserCarService userCarService) {
        this.userCarService = userCarService;
    }

    // 为用户添加车辆
    @PostMapping(path = "/addCar2User")
    public @ResponseBody
    ResponseEntity<String> addCar2User(@RequestBody UserCarEntity userCarEntity) {
        if (!userCarService.addCar2User(userCarEntity)) {
            return new ResponseEntity<>("Add UserCar Failed. User-Car existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID硬删除用户车辆
    @PostMapping(path = "/deleteUserCarById")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarById(@RequestBody UserCarEntity userCarEntity) {
        userCarService.deleteUserCarById(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户ID硬删除用户车辆
    @PostMapping(path = "/deleteUserCarByUserId")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarByUserId(@RequestBody UserCarEntity userCarEntity) {
        userCarService.deleteUserCarByUserId(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名硬删除用户车辆
    @PostMapping(path = "/deleteUserCarByUsername")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarByUsername(@RequestBody UserCarEntity userCarEntity) {
        userCarService.deleteUserCarByUsername(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID硬删除用户车辆
    @PostMapping(path = "/deleteUserCarByCarId")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarByCarId(@RequestBody UserCarEntity userCarEntity) {
        userCarService.deleteUserCarByCarId(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆名硬删除用户车辆
    @PostMapping(path = "/deleteUserCarByCarName")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarByCarName(@RequestBody UserCarEntity userCarEntity) {
        userCarService.deleteUserCarByCarName(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody UserCarEntity userCarEntity) {
        userCarService.updateStatusById(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody UserCarEntity userCarEntity) {
        userCarService.updateRemarkById(userCarEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找角用户车辆
    @PostMapping(path = "/searchUserCarById")
    public @ResponseBody
    UserCarEntity searchUserCarById(@RequestBody UserCarEntity userCarEntity) {
        return userCarService.searchUserCarById(userCarEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户ID查找用户车辆
    @PostMapping(path = "/searchUserCarByUserId")
    public @ResponseBody
    Page<UserCarEntity> searchUserCarByUserId(@RequestBody UserCarEntity userCarEntity) {
        return userCarService.searchUserCarByUserId(userCarEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户名查找用户车辆
    @PostMapping(path = "/searchUserCarByUsername")
    public @ResponseBody
    Page<UserCarEntity> searchUserCarByUsername(@RequestBody UserCarEntity userCarEntity) {
        return userCarService.searchUserCarByUsername(userCarEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID查找用户车辆
    @PostMapping(path = "/searchUserCarByCarId")
    public @ResponseBody
    Page<UserCarEntity> searchUserCarByCarId(@RequestBody UserCarEntity userCarEntity) {
        return userCarService.searchUserCarByCarId(userCarEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆名查找用户车辆
    @PostMapping(path = "/searchUserCarByCarName")
    public @ResponseBody
    Page<UserCarEntity> searchUserCarByCarName(@RequestBody UserCarEntity userCarEntity) {
        return userCarService.searchUserCarByCarName(userCarEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部用户车辆
    @PostMapping(path = "/searchAllUserCar")
    public @ResponseBody
    Page<UserCarEntity> searchAllUserCar(@RequestBody UserCarEntity userCarEntity) {
        return userCarService.searchAllUserCar(userCarEntity);
    }
}
