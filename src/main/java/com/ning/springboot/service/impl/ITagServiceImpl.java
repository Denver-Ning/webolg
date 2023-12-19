package com.ning.springboot.service.impl;

import com.ning.springboot.entity.Tag;
import com.ning.springboot.mapper.TagMapper;
import com.ning.springboot.service.ITagService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

@Service
public class ITagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Override
    public List<Tag> selectList(String tagName) {
        return baseMapper.selectList(tagName);
    }
    @Override
    public void insert(Tag tag) {
        baseMapper.insert(tag);
    }

    @Override
    public void deleteById(Tag tag) {
        baseMapper.deleteById(tag);
    }
    @Override
    public List<Tag> list() {
        return baseMapper.list();
    }
}