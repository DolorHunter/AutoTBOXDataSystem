package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.CarEntity;
import com.autotboxdatasystem.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/Car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // 添加车辆
    @PostMapping(path = "/addCar")
    public @ResponseBody
    ResponseEntity<String> addCar(@RequestBody CarEntity carEntity) {
        if (!carService.addCar(carEntity)) {
            return new ResponseEntity<>("Add Car Failed. Car name existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 硬删除车辆
    @PostMapping(path = "/hardDeleteCarById")
    public @ResponseBody
    ResponseEntity<String> hardDeleteCarById(@RequestBody CarEntity carEntity) {
        carService.hardDeleteCarById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 软删除车辆
    @PostMapping(path = "/softDeleteCarById")
    public @ResponseBody
    ResponseEntity<String> softDeleteCarById(@RequestBody CarEntity carEntity) {
        carService.softDeleteCarById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 恢复软删除车辆
    @PostMapping(path = "/restoreCarById")
    public @ResponseBody
    ResponseEntity<String> restoreCarById(@RequestBody CarEntity carEntity) {
        carService.restoreCarById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 激活车辆
    @PostMapping(path = "/activateCarById")
    public @ResponseBody
    ResponseEntity<String> activateCarById(@RequestBody CarEntity carEntity) {
        carService.activateCarById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 禁用车辆
    @PostMapping(path = "/deactivateCarById")
    public @ResponseBody
    ResponseEntity<String> deactivateCarById(@RequestBody CarEntity carEntity) {
        carService.deactivateCarById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody CarEntity carEntity) {
        carService.updateStatusById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody CarEntity carEntity) {
        carService.updateRemarkById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 GENERAL
    @PostMapping(path = "/updateGeneralById")
    public @ResponseBody
    ResponseEntity<String> updateCarById(@RequestBody CarEntity carEntity) {
        carService.updateGeneralById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 DRIVE
    @PostMapping(path = "/updateDriveById")
    public @ResponseBody
    ResponseEntity<String> updateDriveById(@RequestBody CarEntity carEntity) {
        carService.updateDriveById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 FUEL ENGINE
    @PostMapping(path = "/updateFuelEngineById")
    public @ResponseBody
    ResponseEntity<String> updateFuelEngineById(@RequestBody CarEntity carEntity) {
        carService.updateFuelEngineById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 ELECTROMOTOR
    @PostMapping(path = "/updateElectroMotorById")
    public @ResponseBody
    ResponseEntity<String> updateElectroMotorById(@RequestBody CarEntity carEntity) {
        carService.updateElectroMotorById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 PERFORMANCE
    @PostMapping(path = "/updatePerformanceById")
    public @ResponseBody
    ResponseEntity<String> updatePerformanceById(@RequestBody CarEntity carEntity) {
        carService.updatePerformanceById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 CHASSIS
    @PostMapping(path = "/updateChassisById")
    public @ResponseBody
    ResponseEntity<String> updateChassisById(@RequestBody CarEntity carEntity) {
        carService.updateChassisById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 TRANSMISSION
    @PostMapping(path = "/updateTransmissionById")
    public @ResponseBody
    ResponseEntity<String> updateTransmissionById(@RequestBody CarEntity carEntity) {
        carService.updateTransmissionById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新车辆信息 SERVICE AND WARRANTY
    @PostMapping(path = "/updateServiceAndWarrantyById")
    public @ResponseBody
    ResponseEntity<String> updateServiceAndWarrantyById(@RequestBody CarEntity carEntity) {
        carService.updateServiceAndWarrantyById(carEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找车辆
    @PostMapping(path = "/searchCarById")
    public @ResponseBody
    CarEntity searchCarById(@RequestBody CarEntity carEntity) {
        return carService.searchCarById(carEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆名查找车辆
    @PostMapping(path = "/searchCarByCarName")
    public @ResponseBody
    CarEntity searchCarByCarName(@RequestBody CarEntity carEntity) {
        return carService.searchCarByCarName(carEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找激活车辆
    @PostMapping(path = "/searchActivedCar")
    public @ResponseBody
    Page<CarEntity> searchActivedCar(@RequestBody CarEntity carEntity) {
        return carService.searchActivedCar(carEntity);
    }

    // 查找全部车辆
    @PostMapping(path = "/searchAllCar")
    public @ResponseBody
    Page<CarEntity> searchAllCar(@RequestBody CarEntity carEntity) {
        return carService.searchAllCar(carEntity);
    }
}
