/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.repository;

import com.mall.admin.entity.User;
import com.mall.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author lidai
 * @date 2019/7/3 11:36
 * <p>
 * 使用HQL一定要用实体类中映射得属性
 */
public interface UserRepository extends BaseRepository<User, Integer> {

    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query("delete from User where userId in (?1)")
    void batchDeleteByUserIds(Integer[] userIds);
}

