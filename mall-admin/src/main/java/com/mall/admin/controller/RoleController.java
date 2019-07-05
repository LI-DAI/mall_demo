/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.controller;

import com.mall.admin.entity.Role;
import com.mall.admin.service.RoleService;
import com.mall.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidai
 * @date 2019/7/5 14:14
 * @since
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色操作")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增角色", httpMethod = "POST")
    public Result insertRole(@RequestBody Role role) {
        try {
            roleService.insertRole(role);
            return Result.build().success("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }
}

