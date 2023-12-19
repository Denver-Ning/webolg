package com.ning.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ning.springboot.common.Result;
import com.ning.springboot.entity.Article;
import com.ning.springboot.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    /**
     * 查询列表
     * @return 返回列表
     */
    @GetMapping("/list")
    public Result selectList(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false) String articleName
    ){
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleService.selectList(articleName);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Article article){
        articleService.insert(article);
        return Result.success(true);
    }
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id){
        Article article = articleService.getById(id);
        return Result.success(article);
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        articleService.deleteById(id);
        return Result.success(true);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article){
        articleService.updateById(article);
        return Result.success(article);
    }
}
