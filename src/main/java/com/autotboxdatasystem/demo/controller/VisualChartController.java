package com.autotboxdatasystem.demo.controller;

import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.VisualChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/VisualChart")
public class VisualChartController {
    private final VisualChartService visualChartService;

    @Autowired
    public VisualChartController(VisualChartService visualChartService) {
        this.visualChartService = visualChartService;
    }

    // 添加视觉图表
    @PostMapping(path = "/addVisualChart")
    public @ResponseBody
    ResponseEntity<String> addVisualChart(@RequestBody VisualChartEntity visualChartEntity) {
        if (!visualChartService.addVisualChart(visualChartEntity)) {
            return new ResponseEntity<>("Add VisualChart Failed. Chart Exist.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID删除视觉图表
    @PostMapping(path = "deleteVisualChartById")
    public @ResponseBody
    ResponseEntity<String> deleteVisualChartById(@RequestBody VisualChartEntity visualChartEntity){
        visualChartService.deleteVisualChartById(visualChartEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 图表名删除视觉图表
    @PostMapping(path = "deleteVisualChartByChartName")
    public @ResponseBody
    ResponseEntity<String> deleteVisualChartByChartName(@RequestBody VisualChartEntity visualChartEntity){
        visualChartService.deleteVisualChartByChartName(visualChartEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新状态
    @PostMapping(path = "/updateStatusById")
    public @ResponseBody
    ResponseEntity<String> updateStatusById(@RequestBody VisualChartEntity visualChartEntity) {
        visualChartService.updateStatusById(visualChartEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // 更新备注
    @PostMapping(path = "/updateRemarkById")
    public @ResponseBody
    ResponseEntity<String> updateRemarkById(@RequestBody VisualChartEntity visualChartEntity) {
        visualChartService.updateRemarkById(visualChartEntity);
        return new ResponseEntity<>("Succeed.", HttpStatus.OK);
    }

    // ID查找视觉图表
    @PostMapping(path = "/searchVisualChartById")
    public @ResponseBody
    VisualChartEntity searchVisualChartById(@RequestBody VisualChartEntity visualChartEntity) {
        return visualChartService.searchVisualChartById(visualChartEntity);
    }

    // 图表名查找视觉图表
    @PostMapping(path = "/searchVisualChartByChartName")
    public @ResponseBody
    VisualChartEntity searchVisualChartByChartName(@RequestBody VisualChartEntity visualChartEntity) {
        return visualChartService.searchVisualChartByChartName(visualChartEntity);
    }

    // 查找全部视觉图表
    @PostMapping(path = "/searchAllVisualChartList")
    public @ResponseBody
    List<VisualChartEntity> searchAllVisualChartList(@RequestBody VisualChartEntity visualChartEntity) {
        return visualChartService.searchAllVisualChartList(visualChartEntity);
    }

    // 查找全部视觉图表
    @PostMapping(path = "/searchAllVisualChartPager")
    public @ResponseBody
    Page<VisualChartEntity> searchAllVisualChartPager(@RequestBody VisualChartEntity visualChartEntity) {
        return visualChartService.searchAllVisualChartPager(visualChartEntity);
    }
}
