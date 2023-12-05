package com.ning.springboot.mapper;

import com.ning.springboot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宁
 * @since 2023-10-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
