package com.ning.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ning.springboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> selectList(String categoryName);
}
