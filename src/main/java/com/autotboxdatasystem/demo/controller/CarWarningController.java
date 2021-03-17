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

    // 车辆Vin硬删除故障
    @PostMapping(path = "/deleteCarWarningByVin")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningByVin(@RequestBody CarWarningEntity userCarWarningEntity) {
        userCarWarningService.deleteCarWarningByVin(userCarWarningEntity);
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
    @PostMapping(path = "/searchCarWarningByVinList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByVinList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByVinList(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID查找故障
    @PostMapping(path = "/searchCarWarningByVinPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByVinPager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByVinPager(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误内容查找故障
    @PostMapping(path = "/searchCarWarningByErrorContentList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByErrorContentList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByErrorContentList(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误内容查找故障
    @PostMapping(path = "/searchCarWarningByErrorContentPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByErrorContentPager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByErrorContentPager(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误单元查找故障
    @PostMapping(path = "/searchCarWarningByFaultCategoryList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByFaultCategoryList(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByFaultCategoryList(userCarWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误单元查找故障
    @PostMapping(path = "/searchCarWarningByFaultCategoryPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByFaultCategoryPager(@RequestBody CarWarningEntity userCarWarningEntity) {
        return userCarWarningService.searchCarWarningByFaultCategoryPager(userCarWarningEntity);
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
