package com.ning.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ning.springboot.entity.Category;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    List<Category> selectList(String categoryName);

    void insert(Category category);

    void deleteById(Category category);
    List<Category> list();
}
