package com.ning.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ning.springboot.common.Constants;
import com.ning.springboot.common.Result;
import com.ning.springboot.controller.dto.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.ning.springboot.service.IUserService;
import com.ning.springboot.entity.User;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宁
 * @since 2023-10-29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping
    public Result save(@RequestBody User user) {
        return Result.success(userService.save(user));
    }

    @GetMapping
    public Result findAll() {
        return Result.success(userService.list());
    }

    @PostMapping("/login")
    public Result login(@RequestBody userDto userDto) {
        String name = userDto.getUsername();
        String password = userDto.getPassword();
        if (StrUtil.isBlank(name) || StrUtil.isBlank(password))
            return Result.error(Constants.CODE_403, "参数错误");
        userDto dto = userService.login(userDto);
        return Result.success(dto);
    }

    @PostMapping("/register")
    public Result register(@RequestBody userDto userDto) {
        String name = userDto.getUsername();
        if (StrUtil.isBlank(name))
            return Result.error(Constants.CODE_403, "参数错误");
        userDto flag = userService.register(userDto);
        if (flag == null)
            return Result.error(Constants.CODE_403, "用户名已存在");
        return Result.success(true);
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return Result.success(userService.updateById(user));
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(userService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(userService.removeByIds(ids));
    }


    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(value = "username", required = false, defaultValue = "") String username,
                           @RequestParam(value = "address", required = false, defaultValue = "") String address

    ) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        if (!"".equals(username))
            wrapper.like("username", username);
        if (!"".equals(address))
            wrapper.like("address", address);
        return Result.success(userService.page(new Page<>(pageNum, pageSize), wrapper));
    }
//
//    @GetMapping("/pageUser")
//    public Result pageUser(@RequestParam("pageNum") Integer pageNum,
//                       @RequestParam("pageSize") Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        List<User> users = userMapper.selectList(wrapper);
//        PageInfo<User> userPageInfo = new PageInfo<>(users);
//        return Result.success(userPageInfo);
//    }

    @GetMapping("/pageUserNoMybatisPlus")
    public Result pageUserNoMybatisPlus(@RequestParam("pageNum") Integer pageNum,
                       @RequestParam("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.listAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return Result.success(userPageInfo);
    }
}

