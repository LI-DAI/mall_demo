/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.controller;

import com.mall.admin.entity.Role;
import com.mall.admin.service.RoleService;
import com.mall.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{roleId}")
    @ApiOperation(value = "删除角色", httpMethod = "DELETE")
    @ApiImplicitParam(paramType = "path", name = "roleId", value = "角色id", dataType = "Integer")
    public Result deleteRole(@PathVariable Integer roleId) {
        try {
            roleService.deleteRole(roleId);
            return Result.build().success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取role", httpMethod = "GET")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "roleName", value = "角色名", dataType = "String"),
    })
    public Result getRoleList(Integer page, Integer size, String roleName) {
        try {
            return Result.build().success("获取成功", roleService.getRoleList(page, size, roleName));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }
}

