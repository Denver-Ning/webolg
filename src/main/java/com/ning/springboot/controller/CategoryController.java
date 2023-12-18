package com.ning.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ning.springboot.common.Result;
import com.ning.springboot.entity.Category;
import com.ning.springboot.service.ICategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public Result list(){
        List<Category> list = categoryService.list();
        return Result.success(list);
    }
    @GetMapping("/pageList")
    public Result list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String categoryName
    ){
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryService.selectList(categoryName);
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Category category){
        categoryService.insert(category);
        return Result.success(true);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Category category){
        categoryService.deleteById(category);
        return Result.success();
    }
}
