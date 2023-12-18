package com.ning.springboot.mapper;

import com.ning.springboot.entity.Category;
import com.ning.springboot.entity.Tag;

import java.util.List;

public interface CategoryMapper {
    List<Category> selectList(String categoryName, Integer pageNum, Integer pageSize);

    void insert(Category category);

    void deleteById(Category category);
}
