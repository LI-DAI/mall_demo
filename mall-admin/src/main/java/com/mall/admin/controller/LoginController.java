/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.controller;

import com.mall.admin.entity.User;
import com.mall.admin.service.UserService;
import com.mall.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidai
 * @date 2019/7/18 10:38
 * @since
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        try {
            return userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }

}

