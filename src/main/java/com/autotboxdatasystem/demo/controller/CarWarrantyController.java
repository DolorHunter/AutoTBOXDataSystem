package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.CarWarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/CarWarranty")
public class CarWarrantyController {
    private final CarWarrantyService carWarrantyService;

    @Autowired
    public CarWarrantyController(CarWarrantyService carWarrantyService) {
        this.carWarrantyService = carWarrantyService;
    }

    // 添加车辆保修
    @PostMapping(path = "/addCarWarranty")
    public @ResponseBody
    ResponseEntity<String> addCarWarranty(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        if (!carWarrantyService.addCarWarranty(carWarrantyEntity)) {
            return new ResponseEntity<>("Add CarWarranty Failed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 保修ID硬删除保修
    @PostMapping(path = "/deleteCarWarrantyById")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarrantyById(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        carWarrantyService.deleteCarWarrantyById(carWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN硬删除保修
    @PostMapping(path = "/deleteCarWarrantyByVIN")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarrantyByVIN(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        carWarrantyService.deleteCarWarrantyByVIN(carWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        carWarrantyService.updateStatusById(carWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        carWarrantyService.updateRemarkById(carWarrantyEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 保修ID查找
    @PostMapping(path = "/searchCarWarrantyById")
    public @ResponseBody
    CarWarrantyEntity searchCarWarrantyById(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyService.searchCarWarrantyById(carWarrantyEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN查找保修
    @PostMapping(path = "/searchCarWarrantyByVINList")
    public @ResponseBody
    List<CarWarrantyEntity> searchCarWarrantyByVINList(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyService.searchCarWarrantyByVINList(carWarrantyEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆VIN查找保修
    @PostMapping(path = "/searchCarWarrantyByVINPager")
    public @ResponseBody
    Page<CarWarrantyEntity> searchCarWarrantyByVINPager(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyService.searchCarWarrantyByVINPager(carWarrantyEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部车辆保修
    @PostMapping(path = "/searchAllCarWarrantyList")
    public @ResponseBody
    List<CarWarrantyEntity> searchAllCarWarrantyList(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyService.searchAllCarWarrantyList(carWarrantyEntity);
    }

    // 查找全部车辆保修
    @PostMapping(path = "/searchAllCarWarrantyPager")
    public @ResponseBody
    Page<CarWarrantyEntity> searchAllCarWarrantyPager(@RequestBody CarWarrantyEntity carWarrantyEntity) {
        return carWarrantyService.searchAllCarWarrantyPager(carWarrantyEntity);
    }
}
