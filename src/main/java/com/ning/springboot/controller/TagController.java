package com.ning.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ning.springboot.common.Result;
import com.ning.springboot.entity.Tag;
import com.ning.springboot.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  tag前端控制器
 * </p>
 *
 * @since 2023-10-29
 */
@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagMapper tagService;

    @GetMapping("/list")
    public Result list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam String tagName
    ){
        return Result.success(tagService.selectList(tagName, pageNum, pageSize));
    }
    @PostMapping("/add")
    public Result add(@RequestBody Tag tag){
        tagService.insert(tag);
        return Result.success(true);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Tag tag){
        tagService.deleteById(tag);
        return Result.success();
    }
}
