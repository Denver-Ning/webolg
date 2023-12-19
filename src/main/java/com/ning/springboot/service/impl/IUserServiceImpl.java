package com.ning.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ning.springboot.common.Constants;
import com.ning.springboot.controller.dto.userDto;
import com.ning.springboot.entity.User;
import com.ning.springboot.exception.ServiceException;
import com.ning.springboot.mapper.UserMapper;
import com.ning.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ning.springboot.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 宁
 * @since 2023-10-29
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Log LOG = Log.get();

    @Override
    public userDto login(userDto userDto) {
        User one = getInfo(userDto);
        if (one == null) {
            // 抛出异常
            throw new ServiceException(Constants.CODE_403, "用户名或密码错误");
        } else {
            BeanUtil.copyProperties(one, userDto);
            // 设置token
            String token = TokenUtils.getToken(one.getId().toString(), one.getPassword());
            userDto.setToken(token);
            return userDto;
        }
    }

    @Override
    public userDto register(userDto userDto) {
        User one = getInfo(userDto);
        if (one != null) {
            throw new ServiceException(Constants.CODE_403, "用户名已存在");
        } else {
            User user = new User();
            BeanUtil.copyProperties(userDto, user);
            this.save(user);
            return userDto;
        }
    }

    // 提取公共方法
    public User getInfo(userDto userDto) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", userDto.getUsername());
        query.eq("password", userDto.getPassword());
        User one;
        try {
            one = this.getOne(query);
        } catch (Exception e) {
            LOG.error("登录失败", e);
            throw new ServiceException(Constants.CODE_500, "系统异常");
        }
        return one;
    }
    @Override
    public List<User> listAll() {
        return baseMapper.listAll();
    }
    @Override
    public List<User> pageList(String username, String address) {
        return baseMapper.pageList(username, address);
    }
}
