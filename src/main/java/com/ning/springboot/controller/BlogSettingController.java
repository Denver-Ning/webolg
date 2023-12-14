package com.ning.springboot.controller;

import com.ning.springboot.common.Result;
import com.ning.springboot.entity.BlogSetting;
import com.ning.springboot.mapper.BlogSettingMapper;
import com.ning.springboot.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/setting")
public class BlogSettingController {

    @Autowired
    private BlogSettingMapper blogSettingMapper;



    @PostMapping("/save")
    public Result update(@RequestBody BlogSetting BlogSetting) {
        // 获取id 查询数据库是否有数据
        Integer id = UserUtils.getUserId();
        List<BlogSetting> list = blogSettingMapper.selectDetail(id);
        BlogSetting.setUserId(id);
        if(list.size() == 0){
            // 如果没有数据就插入
            blogSettingMapper.insert(BlogSetting);
            return Result.success(BlogSetting);
        }
        blogSettingMapper.update(BlogSetting);
        return Result.success(BlogSetting);
    }
    @PostMapping
    public Result detail() {
        Integer id = UserUtils.getUserId();
        List<BlogSetting> list = blogSettingMapper.selectDetail(id);
        // 判断如果有信息就查询返回，没有的话就返回空
        if (list.size() == 0) {
            return Result.success();
        }
        return Result.success(list.get(0));
    }
}
