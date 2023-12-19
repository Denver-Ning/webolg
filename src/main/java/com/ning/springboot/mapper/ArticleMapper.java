package com.ning.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ning.springboot.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    int insert(Article article);
    List<Article> selectList(String articleName);
    int deleteById(Integer id);

    int updateById(Article article);

    List<Article> list();
}
