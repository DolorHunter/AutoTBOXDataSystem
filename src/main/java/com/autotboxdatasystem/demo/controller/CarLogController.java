package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.CarLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/CarLog")
public class CarLogController {
    private final CarLogService carLogService;

    @Autowired
    public CarLogController(CarLogService carLogService) {
        this.carLogService = carLogService;
    }

    // 添加车辆日志
    @PostMapping(path = "/addCarLog")
    public @ResponseBody
    ResponseEntity<String> addCarLog(@RequestBody CarLogEntity carLogEntity) {
        if (!carLogService.addCarLog(carLogEntity)) {
            return new ResponseEntity<>("Add CarLog Failed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 日志ID硬删除日志
    @PostMapping(path = "/deleteCarLogById")
    public @ResponseBody
    ResponseEntity<String> deleteCarLogById(@RequestBody CarLogEntity carLogEntity) {
        carLogService.deleteCarLogById(carLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN硬删除日志
    @PostMapping(path = "/deleteCarLogByVIN")
    public @ResponseBody
    ResponseEntity<String> deleteCarLogByVIN(@RequestBody CarLogEntity carLogEntity) {
        carLogService.deleteCarLogByVIN(carLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody CarLogEntity carLogEntity) {
        carLogService.updateStatusById(carLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody CarLogEntity carLogEntity) {
        carLogService.updateRemarkById(carLogEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 日志ID查找
    @PostMapping(path = "/searchCarLogById")
    public @ResponseBody
    CarLogEntity searchCarLogById(@RequestBody CarLogEntity carLogEntity) {
        return carLogService.searchCarLogById(carLogEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN查找日志
    @PostMapping(path = "/searchCarLogByVINList")
    public @ResponseBody
    List<CarLogEntity> searchCarLogByVINList(@RequestBody CarLogEntity carLogEntity) {
        return carLogService.searchCarLogByVINList(carLogEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN查找日志
    @PostMapping(path = "/searchCarLogByVINPager")
    public @ResponseBody
    Page<CarLogEntity> searchCarLogByVINPager(@RequestBody CarLogEntity carLogEntity) {
        return carLogService.searchCarLogByVINPager(carLogEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部车辆日志
    @PostMapping(path = "/searchAllCarLogList")
    public @ResponseBody
    List<CarLogEntity> searchAllCarLog(@RequestBody CarLogEntity carLogEntity) {
        return carLogService.searchAllCarLogList(carLogEntity);
    }

    // 查找全部车辆日志
    @PostMapping(path = "/searchAllCarLogPager")
    public @ResponseBody
    Page<CarLogEntity> searchAllCarLogPager(@RequestBody CarLogEntity carLogEntity) {
        return carLogService.searchAllCarLogPager(carLogEntity);
    }
}
