package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.UserCarWarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/UserCarWarranty")
public class UserCarWarrantyController {
    private final UserCarWarrantyService userCarWarrantyService;

    @Autowired
    public UserCarWarrantyController(UserCarWarrantyService userCarWarrantyService) {
        this.userCarWarrantyService = userCarWarrantyService;
    }

    // 添加用户车辆保修
    @PostMapping(path = "/addUserCarWarranty")
    public @ResponseBody
    ResponseEntity<String> addUserCarWarranty(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        if (!userCarWarrantyService.addUserCarWarranty(userCarWarrantyEntity)) {
            return new ResponseEntity<>("Add UserCarWarranty Failed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 日志ID硬删除保修
    @PostMapping(path = "/deleteUserCarWarrantyById")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarWarrantyById(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyService.deleteUserCarWarrantyById(userCarWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户车辆ID硬删除保修
    @PostMapping(path = "/deleteUserCarWarrantyByUserCarId")
    public @ResponseBody
    ResponseEntity<String> deleteUserCarWarrantyByUserCarId(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyService.deleteUserCarWarrantyByUserCarId(userCarWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyService.updateStatusById(userCarWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        userCarWarrantyService.updateRemarkById(userCarWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 保修ID查找
    @PostMapping(path = "/searchUserCarWarrantyById")
    public @ResponseBody
    UserCarWarrantyEntity searchUserCarWarrantyById(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        return userCarWarrantyService.searchUserCarWarrantyById(userCarWarrantyEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 用户车辆ID查找保修
    @PostMapping(path = "/searchUserCarWarrantyByUserCarId")
    public @ResponseBody
    List<UserCarWarrantyEntity> searchUserCarWarrantyByUserCarId(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        return userCarWarrantyService.searchUserCarWarrantyByUserCarId(userCarWarrantyEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部用户车辆保修
    @PostMapping(path = "/searchAllUserCarWarranty")
    public @ResponseBody
    Page<UserCarWarrantyEntity> searchAllUserCarWarranty(@RequestBody UserCarWarrantyEntity userCarWarrantyEntity) {
        Integer pageIndex = userCarWarrantyEntity.getPageIndex();
        Integer pageSize = userCarWarrantyEntity.getPageSize();
        return userCarWarrantyService.searchAllUserCarWarranty(pageIndex, pageSize);
    }
}
