package com.ning.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ning.springboot.entity.Article;
import com.ning.springboot.mapper.ArticleMapper;
import com.ning.springboot.service.IArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IArticleserviceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Override
    public void insert(Article article) {
        baseMapper.insert(article);
    }
    @Override
    public List<Article> selectList(String articleName) {
        return baseMapper.selectList(articleName);
    }
    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public boolean updateById(Article article) {
        baseMapper.updateById(article);
        return true;
    }
    @Override
    public List<Article> list() {
        return baseMapper.list();

    }
}
