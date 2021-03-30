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
    private final CarWarningService carWarningService;

    @Autowired
    public CarWarningController(CarWarningService carWarningService) {
        this.carWarningService = carWarningService;
    }

    // 添加车辆故障
    @PostMapping(path = "/addCarWarning")
    public @ResponseBody
    ResponseEntity<String> addCarWarning(@RequestBody CarWarningEntity carWarningEntity) {
        if (!carWarningService.addCarWarning(carWarningEntity)) {
            return new ResponseEntity<>("Add CarWarning Failed. CarWarning existed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 故障ID硬删除故障
    @PostMapping(path = "/deleteCarWarningById")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningById(@RequestBody CarWarningEntity carWarningEntity) {
        carWarningService.deleteCarWarningById(carWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆Vin硬删除故障
    @PostMapping(path = "/deleteCarWarningByVin")
    public @ResponseBody
    ResponseEntity<String> deleteCarWarningByVin(@RequestBody CarWarningEntity carWarningEntity) {
        carWarningService.deleteCarWarningByVin(carWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody CarWarningEntity carWarningEntity) {
        carWarningService.updateStatusById(carWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody CarWarningEntity carWarningEntity) {
        carWarningService.updateRemarkById(carWarningEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 故障ID查找
    @PostMapping(path = "/searchCarWarningById")
    public @ResponseBody
    CarWarningEntity searchCarWarningById(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningById(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID查找故障
    @PostMapping(path = "/searchCarWarningByVinList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByVinList(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningByVinList(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 车辆ID查找故障
    @PostMapping(path = "/searchCarWarningByVinPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByVinPager(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningByVinPager(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误内容查找故障
    @PostMapping(path = "/searchCarWarningByErrorContentList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByErrorContentList(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningByErrorContentList(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误内容查找故障
    @PostMapping(path = "/searchCarWarningByErrorContentPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByErrorContentPager(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningByErrorContentPager(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误单元查找故障
    @PostMapping(path = "/searchCarWarningByFaultCategoryList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningByFaultCategoryList(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningByFaultCategoryList(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 错误单元查找故障
    @PostMapping(path = "/searchCarWarningByFaultCategoryPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningByFaultCategoryPager(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningByFaultCategoryPager(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找时间内的车辆故障
    @PostMapping(path = "/searchCarWarningBySendingTimeBetweenList")
    public @ResponseBody
    List<CarWarningEntity> searchCarWarningBySendingTimeBetweenList(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningBySendingTimeBetweenList(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找时间内的车辆故障
    @PostMapping(path = "/searchCarWarningBySendingTimeBetweenPager")
    public @ResponseBody
    Page<CarWarningEntity> searchCarWarningBySendingTimeBetweenPager(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningBySendingTimeBetweenPager(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找时间内的故障详情
    @PostMapping(path = "/searchCarWarningDetailBySendingTimeBetween")
    public @ResponseBody
    List<Object> searchCarWarningDetailBySendingTimeBetween(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchCarWarningDetailBySendingTimeBetween(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找时间内的车辆详情
    @PostMapping(path = "/searchUserCarWarningDetailBySendingTimeBetween")
    public @ResponseBody
    List<Object> searchUserCarWarningDetailBySendingTimeBetween(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchUserCarWarningDetailBySendingTimeBetween(carWarningEntity);
        //return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 查找全部车辆故障
    @PostMapping(path = "/searchAllCarWarningList")
    public @ResponseBody
    List<CarWarningEntity> searchAllCarWarningList(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchAllCarWarningList(carWarningEntity);
    }

    // 查找全部车辆故障
    @PostMapping(path = "/searchAllCarWarningPager")
    public @ResponseBody
    Page<CarWarningEntity> searchAllCarWarningPager(@RequestBody CarWarningEntity carWarningEntity) {
        return carWarningService.searchAllCarWarningPager(carWarningEntity);
    }
}
