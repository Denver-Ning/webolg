package com.ning.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ning.springboot.entity.Category;
import com.ning.springboot.mapper.CategoryMapper;
import com.ning.springboot.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ICategoryImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Override
    public List<Category> selectList(String categoryName) {
        return baseMapper.selectList(categoryName);
    }
    @Override
    public void insert(Category category) {
        baseMapper.insert(category);
    }
    @Override
    public void deleteById(Category category) {
        baseMapper.deleteById(category);
    }
}
