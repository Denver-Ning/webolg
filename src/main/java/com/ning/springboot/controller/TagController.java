package com.ning.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ning.springboot.common.Result;
import com.ning.springboot.entity.Tag;
import com.ning.springboot.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private ITagService tagService;
    @GetMapping("/list")
    public Result list(){
        List<Tag> list = tagService.list();
        return Result.success(list);
    }
    @GetMapping("/pageList")
    public Result list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String tagName
    ){
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> list = tagService.selectList(tagName);
        PageInfo<Tag> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
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
