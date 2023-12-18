package com.ning.springboot.controller;

import com.ning.springboot.common.Result;
import com.ning.springboot.entity.Category;
import com.ning.springboot.entity.Tag;
import com.ning.springboot.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private CategoryMapper categoryService;

    @GetMapping("/list")
    public Result list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String categoryName
    ){
        return Result.success(categoryService.selectList(categoryName, pageNum, pageSize));
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
