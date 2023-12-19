package com.ning.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ning.springboot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> selectList(String tagName);
    List<Tag> list();
}
