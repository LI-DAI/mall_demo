/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.controller;

import com.mall.admin.entity.UserRole;
import com.mall.admin.service.UserRoleService;
import com.mall.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/8 10:18
 * @since
 */
@RestController
@RequestMapping("/user_role")
@Api(value = "用户角色关联操作")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("batch_insert")
    @ApiOperation(value = "批量新增user_role", httpMethod = "POST")
    public Result batchInsertUserRole(@RequestBody List<UserRole> userRoles) {
        try {
            userRoleService.batchInsert(userRoles);
            return Result.build().success("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }
}

