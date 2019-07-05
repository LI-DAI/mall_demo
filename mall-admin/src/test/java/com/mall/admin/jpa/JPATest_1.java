/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.jpa;

import com.mall.admin.entity.User;
import com.mall.admin.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author lidai
 * @date 2019/7/5 11:37
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest_1 {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_1() {
        User user1 = userRepository.getOne(1);
        System.out.println(user1);
        Optional<User> user2 = userRepository.findById(1);
        System.out.println(user2);
    }

    @Test
    public void test_2() {
        Long count = userRepository.count();
        System.out.println(count);
    }

}

