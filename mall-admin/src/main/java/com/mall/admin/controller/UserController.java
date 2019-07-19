/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.controller;

import com.mall.admin.entity.User;
import com.mall.admin.service.UserService;
import com.mall.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author lidai
 * @date 2019/7/3 15:16
 * @since
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户操作")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增用户", httpMethod = "POST")
    @PreAuthorize(value = "hasAuthority('user::add')")
    public Result insertUser(@RequestBody User user) {
        try {
            return Result.build().success(userService.insertUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "根据条件分页获取User", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "nickname", value = "昵称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "页数", dataType = "Integer")
    })
    @PreAuthorize(value = "hasAuthority('user::get')")
    public Result getAllUser(String nickname, String username, Integer page, Integer size) {
        try {
            return Result.build().success(userService.getUserList(username, nickname, page, size));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "根据用户id删除用户", httpMethod = "DELETE")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", dataType = "Integer")
    @PreAuthorize(value = "hasAuthority('user::delete')")
    public Result deleteUserById(@PathVariable Integer userId) {
        try {
            userService.deleteByUserId(userId);
            return Result.build().success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }

    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除用户", httpMethod = "DELETE")
    @ApiImplicitParam(paramType = "query", name = "userIds", value = "用户id数组", dataType = "Array")
    @PreAuthorize(value = "hasAuthority('user::delete')")
    public Result batchDeleteByUserIds(@RequestParam("userIds") Integer[] userIds) {
        try {
            userService.batchDeleteByUserId(userIds);
            return Result.build().success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改用户信息", httpMethod = "PUT")
    @PreAuthorize(value = "hasAuthority('user::update')")
    public Result updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return Result.build().success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }


}

