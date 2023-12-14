package com.ning.springboot.mapper;

import com.ning.springboot.entity.Tag;

import java.util.List;

public interface TagMapper {
    List<Tag> selectList(String tagName, Integer pageNum, Integer pageSize);

    void insert(Tag tag);

    void deleteById(Tag tag);
}
