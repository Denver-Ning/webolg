package com.ning.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ning.springboot.entity.Article;

import java.util.List;

public interface IArticleService extends IService<Article> {
    void insert(Article article);

    List<Article> selectList(String articleName);
    List<Article> list();
    void deleteById(Integer id);

    boolean updateById(Article article);
}
