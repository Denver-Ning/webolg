package com.ning.springboot.controller;

import com.ning.springboot.common.Result;
import com.ning.springboot.entity.BlogSetting;
import com.ning.springboot.mapper.BlogSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog/setting")
public class BlogSettingController {

    @Autowired(required = false)
    private BlogSettingMapper blogSettingMapper;


    @PostMapping
    public Result detail() {
        List<BlogSetting> list = blogSettingMapper.seleceDetail();
        return Result.success();
    }
}
