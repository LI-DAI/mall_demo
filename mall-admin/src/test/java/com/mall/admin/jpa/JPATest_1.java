/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.jpa;

import com.mall.admin.entity.User;
import com.mall.admin.enums.Gender;
import com.mall.admin.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
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

    /**
     * {@link UserRepository#getOne(Object)}此方法延迟加载，什么时候用什么时候加载
     * {@link UserRepository#findById(Object)}此方法立即加载
     */
    @Test
    @Transactional//在测试环境中解决no-session
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

    @Test
    public void test_3() {
        boolean flag = userRepository.existsById(1);
        System.out.println(flag);

        User user = new User();
        user.setUserId(2);
        user.setUsername("lidai");

        ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreNullValues();
        Example<User> example = Example.of(user, matcher);

        boolean flag2 = userRepository.exists(example);
        System.out.println(flag2);
    }

    @Test
    public void test_4() {
        User user = new User("nick", "name2", "word", "jfdkljafsf", "salt", "/re", "123456", Gender.MALE, '0', "fdsa");
        User user2 = new User("fda", "name3", "word", "jfdkljafsf", "salt", "/re", "123456", Gender.FEMALE, '0', "fdsa");
        List<User> users = Arrays.asList(user, user2);
        List<User> userList = userRepository.saveAll(users);
        System.out.println(userList);
    }
}

