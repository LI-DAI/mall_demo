/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service;

import com.mall.admin.repository.UserRepository;
import com.mall.admin.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lidai
 * @date 2019/7/5 11:51
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test_1() {
        Long count = userService.checkUsernameValid("lidai", 2);
        System.out.println(count);

        Long count2 = userService.checkUsernameValid("lidai", null);
        System.out.println(count2);
    }

    @Test
    public void test_2() {
        Integer[] ids = {2, 3};
        userRepository.batchDeleteByUserIds(ids);
    }
}

