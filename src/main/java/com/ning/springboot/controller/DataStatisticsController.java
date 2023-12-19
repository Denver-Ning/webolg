package com.ning.springboot.controller;

import com.ning.springboot.common.Result;
import com.ning.springboot.service.IDataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataStatistics")
public class DataStatisticsController {
    @Autowired
    private IDataStatisticsService IDataStatisticsService;

    @PostMapping
    public Result list() {
        Map<String,Integer> list = IDataStatisticsService.list();
        return Result.success(list);
    }
}
