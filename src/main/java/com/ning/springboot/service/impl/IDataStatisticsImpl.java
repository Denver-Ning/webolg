package com.ning.springboot.service.impl;

import com.ning.springboot.entity.Article;
import com.ning.springboot.entity.Category;
import com.ning.springboot.entity.Tag;
import com.ning.springboot.entity.User;
import com.ning.springboot.service.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IDataStatisticsImpl implements IDataStatisticsService {
    private final IUserService userService;
    private final IArticleService articleService;
    private final ICategoryService categoryService;
    private final ITagService tagService;
    public IDataStatisticsImpl(IUserService userService, IArticleService articleService, ICategoryService categoryService, ITagService tagService) {
        this.userService = userService;
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.tagService = tagService;
    }
    @Override
    public Map<String,Integer> list() {
        int userList = userService.list().size();
        int articleList = articleService.list().size();
        int categoryList = categoryService.list().size();
        int tagList = tagService.list().size();
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("userList", userList);
        resultMap.put("articleList", articleList);
        resultMap.put("categoryList", categoryList);
        resultMap.put("tagList", tagList);

        return resultMap;
    }
}
