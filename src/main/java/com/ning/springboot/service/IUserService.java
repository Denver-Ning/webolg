package com.ning.springboot.service;

import com.ning.springboot.controller.dto.userDto;
import com.ning.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宁
 * @since 2023-10-29
 */
public interface IUserService extends IService<User> {

    userDto login(userDto userDto);

    userDto register(userDto userDto);

    List<User> listAll();
}
