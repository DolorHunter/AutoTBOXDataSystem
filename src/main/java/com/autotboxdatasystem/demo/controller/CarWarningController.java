package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.CarWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/CarWarning")
public class CarWarningController {
    private final CarWarningService userCarWarningService;

    @Autowired
    public CarWarningController(CarWarningService userCarWarningService) {
        this.userCarWarningService = userCarWarningService;
    }

    // 添加车辆故障
    @PostMapping(path = "/addCarWarning")
    public @ResponseBody
    ResponseEntity<String> addCarWarning(@RequestBody CarWarningEntity userCarWarningEntity) {
        if (!userCarWarningService.addCarWarning(userCarWarningEntity)) {
            return new ResponseEntity<>("Add CarWarning Failed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 故障ID硬删除故障
    @PostMapping(path = "/deleteCarWarningById")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningById(@RequestBody CarWarningEntity userCarWarningEntity) {
        userCarWarningService.deleteCarWarningById(userCarWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN硬删除故障
    @PostMapping(path = "/deleteCarWarningByVIN")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningByVIN(@RequestBody CarWarningEntity userCarWarningEntity) {
        userCarWarningService.deleteCarWarningByVIN(userCarWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody CarWarningEntity userCarWarningEntity) {
        userCarWarningService.updateStatusById(userCarWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody CarWarningEntity userCarWarningEntity) {
        userCarWarningService.updateRemarkById(userCarWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 故障ID查找
    @PostMapping(path = "/searchCarWarningById")
    public @ResponseBody
    CarWarningEntity searchCarWarningById(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningById(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID查找故障
    @PostMapping(path = "/searchCarWarningByVINList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByVINList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByVINList(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID查找故障
    @PostMapping(path = "/searchCarWarningByVINPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByVINPager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByVINPager(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆名查找故障
    @PostMapping(path = "/searchCarWarningByCarNameList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByCarNameList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByCarNameList(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆名查找故障
    @PostMapping(path = "/searchCarWarningByCarNamePager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByCarNamePager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByCarNamePager(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 单元名查找故障
    @PostMapping(path = "/searchCarWarningByUnitList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByUnitList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByUnitList(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 单元名查找故障
    @PostMapping(path = "/searchCarWarningByUnitPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByUnitPager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByUnitPager(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部车辆故障
    @PostMapping(path = "/searchAllCarWarningList")
    public @ResponseBody
    List<CarWarningEntity> searchAllCarWarningList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchAllCarWarningList(userCarWarningEntity);
    }

    // 查找全部车辆故障
    @PostMapping(path = "/searchAllCarWarningPager")
    public @ResponseBody
    Page<CarWarningEntity> searchAllCarWarningPager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchAllCarWarningPager(userCarWarningEntity);
    }
}
