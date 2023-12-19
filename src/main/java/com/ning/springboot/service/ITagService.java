package com.ning.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.ning.springboot.entity.Tag;

import java.util.List;

public interface ITagService extends IService<Tag> {

    List<Tag> selectList(String tagName);

    void insert(Tag tag);

    void deleteById(Tag tag);
    List<Tag> list();
}
