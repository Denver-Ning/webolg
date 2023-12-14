package com.ning.springboot.mapper;


import com.ning.springboot.entity.BlogSetting;

import java.util.List;

public interface BlogSettingMapper {

    List<BlogSetting> selectDetail(Integer id);


    void update(BlogSetting BlogSetting);

    void insert(BlogSetting BlogSetting);
}
