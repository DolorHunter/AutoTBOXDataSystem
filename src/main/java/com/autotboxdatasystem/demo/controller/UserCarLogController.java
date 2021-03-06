package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.UserCarLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/UserCarLog")
public class UserCarLogController {
    private final UserCarLogService userCarLogService;

    @Autowired
    public UserCarLogController(UserCarLogService userCarLogService) {
        this.userCarLogService = userCarLogService;
    }

    // 添加用户车辆日志
    @PostMapping(path = "/addUserCarLog")
    public @ResponseBody
    ResponseEntity<String> addUserCarLog(@RequestBody UserCarLogEntity userCarLogEntity) {
        if (!userCarLogService.addUserCarLog(userCarLogEntity)) {
            return new ResponseEntity<>("Add UserCarLog Failed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 日志ID硬删除日志
    @PostMapping(path = "/deleteUserCarLogById")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarLogById(@RequestBody UserCarLogEntity userCarLogEntity) {
        userCarLogService.deleteUserCarLogById(userCarLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户车辆ID硬删除日志
    @PostMapping(path = "/deleteUserCarLogByUserCarId")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarLogByUserCarId(@RequestBody UserCarLogEntity userCarLogEntity) {
        userCarLogService.deleteUserCarLogByUserCarId(userCarLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody UserCarLogEntity userCarLogEntity) {
        userCarLogService.updateStatusById(userCarLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody UserCarLogEntity userCarLogEntity) {
        userCarLogService.updateRemarkById(userCarLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 日志ID查找
    @PostMapping(path = "/searchUserCarLogById")
    public @ResponseBody
    UserCarLogEntity searchUserCarLogById(@RequestBody UserCarLogEntity userCarLogEntity) {
        return userCarLogService.searchUserCarLogById(userCarLogEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户车辆ID查找日志
    @PostMapping(path = "/searchUserCarLogByUserCarId")
    public @ResponseBody
    Page<UserCarLogEntity> searchUserCarLogByUserCarId(@RequestBody UserCarLogEntity userCarLogEntity) {
        return userCarLogService.searchUserCarLogByUserCarId(userCarLogEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部用户车辆日志
    @PostMapping(path = "/searchAllUserCarLog")
    public @ResponseBody
    Page<UserCarLogEntity> searchAllUserCarLog(@RequestBody UserCarLogEntity userCarLogEntity) {
        return userCarLogService.searchAllUserCarLog(userCarLogEntity);
    }
}
