/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service;

import com.mall.admin.entity.User;
import org.springframework.data.domain.Page;

/**
 * @author lidai
 * @date 2019/7/3 13:45
 * @since
 */
public interface UserService {

    Page<User> getUserList(String username, String nickname, Integer page, Integer size);

    Integer insertUser(User user);

    void deleteByUserId(Integer userId);

    void batchDeleteByUserId(Integer[] userIds);

    void updateUser(User user);

    User findByUsername(String username);

    Long checkUsernameValid(String username, Integer userId);

}

