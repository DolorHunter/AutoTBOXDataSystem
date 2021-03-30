package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.CarWarningDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/CarWarningDetail")
public class CarWarningDetailController {
    private final CarWarningDetailService carWarningDetailService;

    @Autowired
    public CarWarningDetailController(CarWarningDetailService carWarningDetailService) {
        this.carWarningDetailService = carWarningDetailService;
    }

    // 添加车辆故障详情
    @PostMapping(path = "/addCarWarningDetail")
    public @ResponseBody
    ResponseEntity<String> addCarWarningDetail(@RequestBody CarWarningDetailEntity carWarningDetailEntity){
        if (!carWarningDetailService.addCarWarningDetail(carWarningDetailEntity)){
            return new ResponseEntity<>("Add CarWarningDetail Failed. CarWarningDetial existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 故障详情ID硬删除故障详情
    @PostMapping(path = "/deleteCarWarningDetailById")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningDetailById(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        carWarningDetailService.deleteCarWarningDetailById(carWarningDetailEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆类型硬删除故障详情
    @PostMapping(path = "/deleteCarWarningDetailByCarType")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningDetailByCarType(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        carWarningDetailService.deleteCarWarningDetailByCarType(carWarningDetailEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        carWarningDetailService.updateStatusById(carWarningDetailEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        carWarningDetailService.updateRemarkById(carWarningDetailEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 故障详情ID查找
    @PostMapping(path = "/searchCarWarningDetailById")
    public @ResponseBody
    CarWarningDetailEntity searchCarWarningDetailById(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailService.searchCarWarningDetailById(carWarningDetailEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆型号与故障内容查找故障
    @PostMapping(path = "/searchCarWarningDetailByCarTypeAndErrorContent")
    public @ResponseBody
    CarWarningDetailEntity searchCarWarningDetailByCarTypeAndErrorContent(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailService.searchCarWarningDetailByCarTypeAndErrorContent(carWarningDetailEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆类型查找
    @PostMapping(path = "/searchCarWarningDetailByCarTypeList")
    public @ResponseBody
    List<CarWarningDetailEntity> searchCarWarningDetailByCarTypeList(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailService.searchCarWarningDetailByCarTypeList(carWarningDetailEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误内容查找故障
    @PostMapping(path = "/searchCarWarningDetailByCarTypePager")
    public @ResponseBody
    Page<CarWarningDetailEntity> searchCarWarningDetailByCarTypePager(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailService.searchCarWarningDetailByCarTypePager(carWarningDetailEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部车辆故障详情
    @PostMapping(path = "/searchAllCarWarningDetailList")
    public @ResponseBody
    List<CarWarningDetailEntity> searchAllCarWarningList(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailService.searchAllCarWarningDetailList(carWarningDetailEntity);
    }

    // 查找全部车辆故障详情
    @PostMapping(path = "/searchAllCarWarningDetailPager")
    public @ResponseBody
    Page<CarWarningDetailEntity> searchAllCarWarningPager(@RequestBody CarWarningDetailEntity carWarningDetailEntity) {
        return carWarningDetailService.searchAllCarWarningDetailPager(carWarningDetailEntity);
    }
}
